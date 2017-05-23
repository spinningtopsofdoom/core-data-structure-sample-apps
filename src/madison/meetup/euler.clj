(ns madison.meetup.euler
  (:require [clojure.string :as string]))

(def names (slurp "names.txt"))
(def sorted-names (sort (string/split (string/replace names "\"" "") #",")))

(defn index-of [^Character x]
  (Character/getNumericValue x))
(def A-INDEX (index-of \A))
(defn word-score [word]
  (reduce #(+ %1 1 (- (index-of %2) A-INDEX)) 0 word))

(reduce + (map-indexed (fn [idx word] (* (inc idx) (word-score word))) sorted-names))