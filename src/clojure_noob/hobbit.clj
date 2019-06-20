(ns clojure-noob.hobbit
  (:gen-class))

(def asym-hobbit-body-parts [{:name "hair" :size 3}
                             {:name "head" :size 5}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "nose" :size 1}
                             {:name "mouth" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "upper-arm" :size 4}
                             {:name "fore-arm" :size 3}
                             {:name "left-arm" :size 9}
                             {:name "chest" :size 8}
                             {:name "left-kidney" :size 2}
                             {:name "abdomen" :size 2}
                             {:name "back" :size 8}
                             {:name "left-thigh" :size 5}
                             {:name "left-knee" :size 2}
                             {:name "left-lower-leg" :size 5}
                             {:name "left-achille" :size 2}
                             {:name "left-foot" :size 2}])

((:name (get asym-hobbit-body-parts 4))



(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

 (defn symmetrize-body-parts
    [asym-body-parts]
       (loop [remaining-asym-parts asym-body-parts
               final-body-parts []]
              (if (empty? remaining-asym-parts)
                  final-body-parts
                        (let [[part & remaining] remaining-asym-parts]
                                    (recur remaining
                                             (into final-body-parts
                                                   (set [part (matching-part part)])))))))


(symmetrize-body-parts asym-hobbit-body-parts)

(defn better-symmetrize-body-parts
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          [] ;;initial value
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

