(ns tennis-tree
  (:require [clojure.math.numeric-tower :as math]
            [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [semantic-csv.core :as sc]))

(defn match-probability [player-1-rating player-2-rating]
  (/ 1
    (+ 1 (math/expt 10 (/ (- player-2-rating player-1-rating) 400)))))

(defn recalculate-rating [k previous-rating expected-outcome real-outcome]
  (+ previous-rating (* k (- real-outcome expected-outcome))))

(defn elo-world-simple
  ([csv k]
   (with-open [r (io/reader csv)]
     (->> (csv/read-csv r)
       sc/mappify
       (sc/cast-with {:winner_sets_won sc/->int
                      :loser_sets_won sc/->int
                      :winner_games_won sc/->int
                      :loser_games_won sc/->int})
       (reduce (fn [{:keys [players] :as acc} {:keys [:winner_name :winner_slug
                                                      :loser_name :loser_slug] :as match}]
                 (let [winner-rating (get players winner_slug 400)
                       loser-rating (get players loser_slug 400)
                       winner-probability (match-probability winner-rating loser-rating)
                       loser-probability (- 1 winner-probability)
                       predictable-match? (not= winner-rating loser-rating)
                       prediction-correct? (> winner-rating loser-rating)
                       correct-predictions (if (and predictable-match? prediction-correct?)
                                             (inc (:correct-predictions acc))
                                             (:correct-predictions acc))
                       predictable-matches (if predictable-match?
                                             (inc (:predictable-match-count acc))
                                             (:predictable-match-count acc))]

                   (-> acc
                     (assoc :predictable-match-count predictable-matches)
                     (assoc :correct-predictions correct-predictions)
                     (assoc-in [:players winner_slug] (recalculate-rating k winner-rating winner-probability 1))
                     (assoc-in [:players loser_slug] (recalculate-rating k loser-rating loser-probability 0))
                     (update :match-count inc))))
         {:players {}
          :match-count 0
          :predictable-match-count 0
          :correct-predictions 0})))))

