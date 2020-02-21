(ns clojure-noob.cal
  (:gen-class))
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn cal 
  [numbers]
  (map #(% numbers) [sum count avg]))
(cal [1 2 3])
(cal [54 32 64 33])
