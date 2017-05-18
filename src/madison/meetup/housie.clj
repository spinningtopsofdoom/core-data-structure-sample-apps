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

(def empty-card
  (into [] (repeat 3 (into [] (repeat 9 nil)))))

(defn generate-card [card-columns base-card]
  (first
    (reduce
      (fn [[card columns] row]
        (let [row-columns (set (take 5 (remove #(empty? (nth columns %)) (shuffle (range 9)))))
              new-card (reduce #(assoc-in %1 [row %2] (first (nth card-columns %2))) card row-columns)]
          [new-card (map-indexed #(if (contains? row-columns %1) (rest %2) %2) columns)]))
      [base-card card-columns]
      (range 3))))