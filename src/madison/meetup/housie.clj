(ns madison.meetup.housie)

(defn generate-column-numbers []
  (let [custom-range {0 9 8 11}
        column-numbers (mapv #(range (* 10 %) (+ (get custom-range % 10) (* 10 %))) (range 9))]
    (update column-numbers 0 #(map inc %))))

(defn generate-card-choices []
  (let [base-numbers (into [] (range 9))
        extra-numbers (mapcat #(repeat 2 %) (range 9))]
    (into base-numbers (take 6 (shuffle extra-numbers)))))

(defn generate-card-numbers [card-choices column-numbers]
  (let [choice-map (frequencies card-choices)]
    (map #(sort (take (get choice-map % 0) (shuffle (get column-numbers %)))) (range 9))))

(defn generate-card [card-columns]
  (first
    (reduce
      (fn [[card columns] row-num]
        (let [base-columns (keep-indexed #(if (= row-num (count %2)) %1) columns)
              optional-columns (filter #(< 0 (count (nth columns %)) row-num) (shuffle (range 9)))
              row-columns (take 5 (concat base-columns optional-columns))
              column-nums (map #(first (nth columns %)) row-columns )
              column-map (zipmap row-columns column-nums)
              row (mapv #(get column-map %) (range 9))]
          [(conj card row) (map-indexed #(if (contains? column-map %1) (rest %2) %2) columns)]))
      [[] card-columns]
      (range 3 0 -1))))
