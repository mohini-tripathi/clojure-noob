(ns clojure-noob.val-retrieve
  (:gen-class))
(def chart [{:name "mohini" :project "apple"}
      {:name "sara" :project "banana"}
      {:name "serra" :project "guava"}])
(map chart :project :name )

(cons 55 [23 21 22] )

(empty? [])                           