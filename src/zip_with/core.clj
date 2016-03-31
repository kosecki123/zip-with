(ns zip-with.core)

(defn- abs [n] (max n (- n)))

(defn- in-coll [coll pred val]
  (let [in-range (filter (partial pred val) coll)
        best-match (first (sort-by #(abs (- % val)) in-range))]
    [val best-match]))

(defn zip-with [coll1 coll2 pred]
  (map (partial in-coll coll2 pred) coll1))
