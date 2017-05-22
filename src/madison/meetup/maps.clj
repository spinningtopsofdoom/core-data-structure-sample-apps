(ns madison.meetup.maps)

;; =============== Map Creation ===============

(def animals {:cat 1 :dog 2 :beaver 3 :muskrat 4 :newt 5 :clownfish 6 :eagle 7 :komodo 8 :grasshopper 9})
(def empty-map {})

(hash-map :cat 1 :dog 2 :beaver 3 :muskrat 4 :newt 5 :clownfish 6 :eagle 7 :komodo 8 :grasshopper 9)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 5}
(hash-map)
; => {}

;; =============== Common Operations ===============

(animals :newt)
; => :5

(conj empty-map [:dune 42] [:desert :planet])
; => {:dune 42, :desert :planet}
(conj animals [:one-fish 1])
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :one-fish 1, :komodo 8, :muskrat 4, :newt 5}

(first animals)
; => [:eagle 7]
(rest animals)
; => ([:cat 1] [:grasshopper 9] [:dog 2] [:clownfish 6] [:beaver 3] [:komodo 8] [:muskrat 4] [:newt 5])

(count animals)
; => 9
(count empty-map)
; => 0

(get animals :cat)
; => :red
(get animals :unicorn)
; => nil
(get animals :unicorn :unknown)
; => :unknown

(assoc animals :newt :green)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt :green}
(assoc animals :horse 10)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 5, :horse 10}

(update animals :dog inc)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 5, :horse 10}
(update animals :pegasus identity)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :pegasus nil, :komodo 8, :muskrat 4, :newt 5}

;; =============== Map Operations ===============

(dissoc animals :grasshopper :beaver)
; => {:eagle 7, :cat 1, :dog 2, :clownfish 6, :komodo 8, :muskrat 4, :newt 5}
(dissoc animals :lion)
; => {:eagle 7, :cat 1, :grasshopper 9, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 5}

(keys animals)
; => (:eagle :cat :grasshopper :dog :clownfish :beaver :komodo :muskrat :newt)
(vals animals)
; => (7 1 9 2 6 3 8 4 5)

(select-keys animals [:eagle :komodo :muskrat])
; => {:eagle 7, :komodo 8, :muskrat 4}

(merge animals {:dog :woof :cat :meow})
; => {:eagle 7, :cat :meow, :grasshopper 9, :dog :woof, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 5}

(merge-with + animals {:newt 1000 :grasshopper 10000})
; => {:eagle 7, :cat 1, :grasshopper 10009, :dog 2, :clownfish 6, :beaver 3, :komodo 8, :muskrat 4, :newt 1005}