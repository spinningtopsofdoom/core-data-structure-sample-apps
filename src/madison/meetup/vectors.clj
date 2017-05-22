(ns madison.meetup.vectors)

;; =============== Vector Creation ===============

(def items ["dune" 42 :purple :red "plant"])
(def empty-vector [])

(vector "dune" 42 :purple :red "plant")
; => ["dune" 42 :purple :red "plant"]
(vector)
; => []

;; =============== Common Operations ===============

(items 3)
; => :red

(conj empty-vector "dune" 42)
; => ["dune" 42]
(conj items :one-fish :two-fish)
; => ["dune" 42 :purple :red "plant" :one-fish :two-fish]

(first items)
; => "dune"
(rest items)
; => (42 :purple :red "plant")

(count items)
; => 5
(count empty-vector)
; => 0

(get items 3)
; => :red
(get items 10)
; => nil
(get items 10 :unknown)
; => :unknown

(assoc items 3 :green)
; => ["dune" 42 :purple :green "plant"]
(assoc items 10 :green)
; => IndexOutOfBounds

(update items 1 inc)
; => ["dune" 43 :purple :red "plant"]
(update items 10 identity)
; => IndexOutOfBounds

;; =============== Vector Operations ===============

(nth items 3)
; => :red
(nth items 10)
; => IndexOutOfBounds
(nth items 10 :unknown)
; => :unknown

(subvec items 1 3)
; => [42 :purple]
(subvec items 1 10)
; => IndexOutOfBounds