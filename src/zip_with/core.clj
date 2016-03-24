(ns zip-with.core)

(defn- abs [n] (max n (- n)))

(defn- deltas [val1 val2]
  [val2 (abs (- val1 val2))]
  )

(defn- in-coll [coll pred val]
  (let [
    in-range (filter (partial pred val) coll)
    diffs (map (partial deltas val) in-range)
    best-match (ffirst (sort-by last diffs))
    ]
  [val best-match]
  ))

(defn zip-with [coll1 coll2 pred]
  (map (partial in-coll coll2 pred) coll1)
  )
