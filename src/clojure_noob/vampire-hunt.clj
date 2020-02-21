(ns clojure-noob.vampire-hunt
  (:gen-class))

(def vampire-database
  {
   0 {:name "Mohini" :makes-blood-puns? true, :has-pulse? false}
   1 {:name "Ariti" :makes-blood-puns? false, :has-pules? false}
   2 {:name "Roshani" :makes-blood-puns? true, :has-pulse? true}})
(defn vampire-details
  [social-ID]
  (Thread/sleep 1000)
  (get vampire-database social-ID))
(defn Is-vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))
(defn identiafy-vampire
  [social-ID]

  (first (filter Is-vampire?
                 (map vampire-details social-ID )) ))
 (time (def mapped-details (map vampire-details (range 0 1000000))))
(time (first mapped-details))
(time (identify-vampire (range 0 1000000)))