(ns )
(def base-co2 382)
(def base-year 2006)

(defn co-emissions
  "We will use the year 2006 as a starting point with a CO2 level of 382 ppm and calculate the estimate using a simplified (and optimistic) linear function, as follows: Estimate = 382 + ((Year - 2006) * 2)."
  [year]
  ((let [year-diff (- year base-year)]
     (+ base-co2 (* year-diff 2)))))

(defn co-emissions "asdasda" [year] (let [year-diff (- year base-year)] (+ base-co2 (* year-diff 2))))

