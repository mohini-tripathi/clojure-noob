(ns clojure-noob.core
  (:gen-class))



(def human-intake
  [6 7 5 3 ])
(def critter-intake
  [0 0 1 2])
(defn human-critter-intake
  [human critter]
  {:human human :critter critter})
(map human-critter-intake human-intake critter-intake)
