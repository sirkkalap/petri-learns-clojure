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
      ;; TODO: still not there
      )))
(defn find-path [route-lookup origin destination]
  (find-path* route-lookup destination [origin]))