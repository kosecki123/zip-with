(ns zip-with.core-test
  (:require [clojure.test :refer :all]
            [zip-with.core :refer :all]))

(defn- abs [n] (max n (- n)))

(deftest b-test
  (let [coll1 [1 2 3 4 5]
        coll2 [0.1 0.2 0.5 0.8 1.2 1.5 1.8 3.3 5]
        delta 0.5
        pred (fn [val1 val2] (<= (abs (- val1 val2)) delta))
        result (zip-with coll1 coll2 pred)
        first-five (take 5 result)
        expected-five [[1 0.8] [2 1.8] [3 3.3] [4 nil] [5 5]]]
    (testing "Checking first five elements from result"
      (is (= first-five expected-five)))))
