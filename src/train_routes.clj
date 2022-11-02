(ns train-routes)
(def routes
  [[:paris :london 236]
   [:paris :frankfurt 121]
   [:paris :milan 129]
   [:milan :rome 95]
   [:milan :barcelona 258]
   [:barcelona :madrid 141]
   [:madrid :lisbon 127]
   [:sevilla :lisbon 138]
   [:madrid :sevilla 76]
   [:barcelona :sevilla 203]
   [:madrid :paris 314]
   [:frankfurt :milan 204]
   [:frankfurt :berlin 170]
   [:frankfurt :geneva 180]
   [:geneva :paris 123]
   [:geneva :milan 85]
   [:frankfurt :prague 148]
   [:milan :vienna 79]
   [:vienna :prague 70]
   [:paris :amsterdam 139]
   [:amsterdam :berlin 176]
   [:amsterdam :frankfurt 140]
   [:vienna :bratislava 15]
   [:bratislava :prague 64]
   [:prague :warsaw 110]
   [:berlin :warsaw 52]
   [:vienna :budapest 43]
   [:prague :budapest 91]])

(defn grouped-routes
  [routes]
  (->> routes
    (group-by first)))

; Testing
(:paris (grouped-routes routes))

(defn route-list->distance-map [route-list]
  (->> route-list
    (map (fn [[_ city cost]] [city cost]))
    (into {})))

; Testing
(route-list->distance-map [[:paris :milan 129]
                           [:paris :frankfurt 121]])

(defn grouped-routes
  [routes]
  (->> routes
    (group-by first)
    (map (fn [[k v]] [k (route-list->distance-map v)]))
    (into {})))

; Testing
(:paris (grouped-routes routes))

(defn grouped-routes
  [routes]
  (->> routes
    (mapcat (fn [[origin-city dest-city cost :as r]]
              [r [dest-city origin-city cost]]))
    (group-by first)
    (map (fn [[k v]] [k (route-list->distance-map v)]))
    (into {})))

; Testing
(:paris (grouped-routes routes))

(def lookup (grouped-routes routes))

; Testing
(get-in lookup [:paris :madrid])
(get-in lookup [:madrid :paris])
(get-in lookup [:paris :bratislava]) ; Route does not exist -> nil

(defn find-path* [route-lookup destination path]
  (let [position (last path)]
    (cond
      (= position destination) path
      (get-in route-lookup [position destination])
      (conj path destination)
      :otherwise-we-search
      (let [path-set (set path)
            from-here (remove path-set (keys (get route-lookup position)))]
        (when-not (empty? from-here)
          (->> from-here
            (map (fn [pos] (find-path* route-lookup destination (conj path pos))))
            (remove empty?)
            (mapcat (fn [x] (if (keyword? (first x))
                              [x]
                              x)))))))))
(defn find-path [route-lookup origin destination]
  (find-path* route-lookup destination [origin]))

; Testing
(find-path* lookup :sevilla [:sevilla])
(find-path lookup :sevilla :sevilla)
(find-path* lookup :madrid [:sevilla]) ; One hop
; Test whether a city is already in our path (let [path-set...])
(set [:amsterdam :paris :milan])
((set [:amsterdam :paris :milan]) :berlin)
((set [:amsterdam :paris :milan]) :paris)
(def small-routes (grouped-routes [[:paris :milan 100]
                                   [:paris :geneva 100]
                                   [:geneva :rome 100]
                                   [:milan :rome 100]]))
(find-path* small-routes :rome [:paris])
(def more-routes (grouped-routes [[:paris :milan 100]
                                  [:paris :geneva 100]
                                  [:paris :barcelona 100]
                                  [:barcelona :milan 100]
                                  [:geneva :rome 100]
                                  [:milan :rome 100]]))
(find-path* more-routes :rome [:paris])
(def even-more-routes (grouped-routes [[:paris :milan 100]
                                       [:paris :geneva 100]
                                       [:paris :barcelona 100]
                                       [:barcelona :madrid 100]
                                       [:madrid :milan 100]
                                       [:barcelona :milan 100]
                                       [:geneva :rome 100]
                                       [:milan :rome 100]]))
(find-path* even-more-routes :rome [:paris])
(find-path* lookup :rome [:paris])

(defn cost-of-route
  [route-lookup route]
  (apply +
    (map (fn [start end]
           (get-in route-lookup [start end]))
      route
      (next route))))

; Testing
(cost-of-route lookup [:london :paris :amsterdam :berlin :warsaw])
(cost-of-route lookup [:london])

(defn min-route [route-lookup routes]
  (reduce (fn [current-best route]
            (let [cost (cost-of-route route-lookup route)]
              (if (or (< cost (:cost current-best))
                    (= 0 (:cost current-best)))
                {:cost cost :best route}
                current-best)))
    {:cost 0 :best [(ffirst routes)]}
    routes))
(defn find-path [route-lookup origin destination]
  (min-route route-lookup (find-path* route-lookup destination [origin])))

; Testing
(find-path lookup :paris :rome) ; 224
(find-path lookup :paris :berlin) ; 291
(find-path lookup :warsaw :sevilla) ; 720
