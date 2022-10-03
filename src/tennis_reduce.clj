(ns tennis-reduce
  (:require
    [clojure.java.io :as io]
    [clojure.data.csv :as csv]
    [semantic-csv.core :as sc]))

(defn tennis-csv->tournament-groups [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (map #(select-keys % [:tourney_slug :winner_name :loser_name]))
      (group-by :tourney_slug))))


(defn tennis-csv->tournament-match-counts [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (group-by :tourney_slug)
      (map (fn [[k ms]] [k (count ms)]))
      (into {}))))

(defn tennis-csv->tournament-match-counts [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      ;;....
      )))

(defn tennis-csv->tournament-match-counts [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (map #(select-keys % [:tourney_slug :winner_name :loser_name]))
      (group-by :tourney_slug))))

(defn streak-string [current-wins current-losses]
  (cond (pos? current-wins) (str "Won " current-wins)
        (pos? current-losses) (str "Lost " current-losses)
        :otherwise "First match of the year"))

(defn serena-williams-win-loss-streaks [matches]
  (:matches
    (reduce (fn [{:keys [current-wins current-losses] :as acc} {:keys [winner-name] :as match}]
              (let [this-match (assoc match :current-streak (streak-string current-wins current-losses))
                    serena-victory? (= winner-name "Williams S.")]
                (-> acc
                  (update :matches #(conj % this-match))
                  (assoc :current-wins (if serena-victory?
                                         (inc current-wins)
                                         0))
                  (assoc :current-losses (if serena-victory?
                                           0
                                           (inc current-losses))))))
      {:matches []
       :current-wins 0
       :current-losses 0}
      matches)))

; Testing
; (in-ns 'tennis-reduce)
(def tournaments (tennis-csv->tournament-match-counts "match_scores_1991-2016_unindexed_csv.csv"))
(sort (keys tournaments))
(take 5 (get tournaments "chicago"))
(count (get tournaments "chicago"))

(defn tennis-csv->tournament-match-counts [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (group-by :tourney_slug)
      (map (fn [[k ms]] [k (count ms)]))
      (into {}))))
(def tournament-totals (tennis-csv->tournament-match-counts "match_scores_1991-2016_unindexed_csv.csv"))
(get tournament-totals "chicago")
(get tournament-totals "wimbledon")
(get tournament-totals "roland-garros")

; Summarizing Tennis Scores
