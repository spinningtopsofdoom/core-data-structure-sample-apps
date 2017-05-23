(ns madison.meetup.bowling
  "Solution for scoring a bwoling game")

(defn emtpy-game []
  {:frames [] :current-frame 0 :score 0 :frame-scores []})

(def MAX-PINS 10)

(defn strike? [frame]
  (= [MAX-PINS] frame))

(defn spare? [frame]
  (= (reduce + frame) MAX-PINS))

(defn score-frame
  ([frame] (score-frame frame [] []))
  ([frame next-frame] (score-frame frame next-frame []))
  ([frame next-frame second-next-frame]
    (if (or (strike? frame) (spare? frame))
      (reduce + (take 3 (concat frame next-frame second-next-frame)))
      (reduce + frame))))

(defn score-frames [frames]
  (let [scoring-frames (partition-all 3 1 frames)]
    (map #(apply score-frame %) scoring-frames)))

(defn update-game [game]
  (let [frames (get game :frames [])
        frame-scores (score-frames frames)]
    (assoc game
      :frame-scores frame-scores
      :current-frame (count frames)
      :score (reduce + frame-scores))))

(defn add-frame [game frame]
  (let [next-frames (conj (get game :frames []) frame)]
    (update-game (assoc game :frames next-frames))))