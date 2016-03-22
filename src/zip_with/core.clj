(ns zip-with.core)

(defn- in-coll [coll pred val]
  [val (first (filter (partial pred val) coll))]
  )

(defn zip-with [coll1 coll2 pred]
  (map (partial in-coll coll2 pred) coll1)
  )
