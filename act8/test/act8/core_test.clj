(ns act8.core-test
  (:require [clojure.test :refer :all]
            [act8.core :refer :all]))

(deftest generate-json-from-hash-test
  (is (= (generate-json-from-hash {:name "John" :occupation "programmer"})
        "{\"name\":\"John\",\"occupation\":\"programmer\"}")))

(deftest generate-hash-from-json-test
  (is (= (generate-hash-from-json "{\"name\":\"Mike\",\"occupation\":\"carpenter\"}")
        {"name" "Mike", "occupation" "carpenter"})))
