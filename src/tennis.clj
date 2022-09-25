(ns tennis
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [semantic-csv.core :as sc]))

(defn first-match [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      first)))

(defn five-matches [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (map #(select-keys % [:tourney_year_id
                            :winner_name
                            :loser_name
                            :winner_sets_won
                            :loser_sets_won]))
      (take 5)
      doall)))

(defn five-matches-int-sets [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (map #(select-keys % [:tourney_year_id
                            :winner_name
                            :loser_name
                            :winner_sets_won
                            :loser_sets_won]))
      (sc/cast-with {:winner_sets_won sc/->int
                     :loser_sets_won sc/->int})
      (take 5)
      doall)))

; Testing
; in REPL: (in-ns 'packt-clj.tennis)
(def csv-file-name "match_scores_1991-2016_unindexed_csv.csv")
(first-match csv-file-name)
(five-matches csv-file-name)
(five-matches-int-sets csv-file-name)

(defn federer-wins [csv]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (filter #(= "Roger Federer" (:winner_name %)))
      (map #(select-keys % [:winner_name
                            :loser_name
                            :winner_sets_won
                            :loser_sets_won
                            :winner_games_won
                            :loser_games_won
                            :tourney_year_id
                            :tourney_slug]))
      doall)))


; Testing
(federer-wins csv-file-name)

; Ex 4.14: A Dedicated Query Function
(defn match-query [csv pred]
  (with-open [r (io/reader csv)]
    (->> (csv/read-csv r)
      sc/mappify
      (filter pred)
      (map #(select-keys % [:winner_name
                            :loser_name
                            :winner_sets_won
                            :loser_sets_won
                            :winner_games_won
                            :loser_games_won
                            :tourney_year_id
                            :tourney_slug]))
      doall)))

; Testing
(count (match-query csv-file-name
         (fn [row] (or (= "Roger Federer" (:winner_name row))
                     (= "Roger Federer" (:loser_name row))))))
(count (federer-wins csv-file-name))

(count (match-query csv-file-name
         #(= (hash-set (:winner_name %) (:looser_name %))
           #{"Roger Federer" "Rafael Nadal"})))