(ns zip-with.core-test
  (:require [clojure.test :refer :all]
            [zip-with.core :refer :all]))

(deftest a-test
  (let [
    coll1 (range 0 1000 10)
    coll2 (range 0 1000 20)
    delta 5
    pred (fn [val1 val2]
      (let [
        r1 (- val2 delta)
        r2 (+ val2 delta)
        ]
        (and (>= val1 r1) (<= val1 r2))))
    result (zip-with coll1 coll2 pred)
    first-five (take 5 result)
    expected-five [0 nil 20 nil 40]
    ]
  (testing "Checking first five elements from result"
    (is (= first-five expected-five)))))
