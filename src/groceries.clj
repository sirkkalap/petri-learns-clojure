(ns groceries)

(def grocery-articles [{:name "Flour"
                        :weight 1000      ; grams
                        :max-dimension 140 ; millimeters
                        }
                       {:name "Bread"
                        :weight 350
                        :max-dimension 250}
                       {:name "Potatoes"
                        :weight 2500
                        :max-dimension 340}
                       {:name "Pepper"
                        :weight 85
                        :max-dimension 90}
                       {:name "Ice cream"
                        :weight 450
                        :max-dimension 200}
                       {:name "Green beans"
                        :weight 300
                        :max-dimension 120}
                       {:name "Olive oil"
                        :weight 400
                        :max-dimension 280}])

(defn article-stream [n]
  (repeatedly n #(rand-nth grocery-articles)))

; Testing
(article-stream 12)
(article-stream 5)

; Recursion at Its Simplest
(defn recursive-sum [so-far numbers]
  (if (first numbers)
    (recursive-sum
      (+ so-far (first numbers))
      (next numbers))
    so-far))

; Testing
(recursive-sum 0 [300 25 1])

; next on empty list returns nil
(next '())

; Ex 6.02: Partitioning Grocery Bags
(defn full-bag? [items]
  (let [weight (apply + (map :weight items))
        size (apply + (map :max-dimension items))]
    (or (> weight 3200)
      (> size 800))))

(full-bag? (article-stream 10))
(full-bag? (article-stream 1))
(full-bag? (article-stream 1000))
(full-bag? '())

(defn bag-sequences* [{:keys [current-bag bags] :as acc} stream]
  ;; TODO: write code
  )
(defn bag-sequences [stream]
  (bag-sequences* {:bags []
                   :current-bag []} stream))
