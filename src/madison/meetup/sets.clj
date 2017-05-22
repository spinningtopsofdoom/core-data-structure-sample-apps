(ns madison.meetup.sets)

;; =============== Set Creation ===============

(def colors #{:red :green :blue :yellow :purple :orange :indigo :violet})
(def empty-set #{})

(hash-set :red :green :blue :yellow :purple :orange :indigo :violet)
; => #{:orange :yellow :green :indigo :violet :red :blue :purple}
(hash-set)
; => #{}

;; =============== Common Operations ===============

(colors :yellow)
; => :yellow

(conj empty-set :dune 42)
; => #{:dune 42}
(conj colors :gold :mauve)
; => #{:orange :yellow :green :indigo :violet :gold :mauve :red :blue :purple}

(first colors)
; => :orange
(rest colors)
; => (:yellow :green :indigo :violet :red :blue :purple)

(count colors)
; => 8
(count empty-set)
; => 0

(get colors :green)
; => :green
(get colors :octeranie)
; => nil
(get colors :octeranie :unknown)
; => :unknown

(assoc colors :blue :green)
; => NotAssociatve
(update colors :green identity)
; => NotAssociatve

;; =============== Set Operations ===============

(disj colors :blue :green)
; => #{:orange :yellow :indigo :violet :red :purple}
(disj colors :octeranie)
; => #{:orange :yellow :green :indigo :violet :red :blue :purple}