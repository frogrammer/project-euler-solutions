(ns project-euler-solutions.core
  (:require [clojure.math.numeric-tower :as math]))

;; Problem 4 - Largest palindrome product
(defn is-palindrome? [num]
  (= (str num) (clojure.string/reverse (str num))))

(defn largest-palindrome [digit]
  (let [min-product (math/expt 10 (dec digit))
        max-product (dec (* min-product 10))
        all-elements (range min-product (inc max-product))]
    (apply max
           (filter is-palindrome?
                   (for [x1 all-elements x2 all-elements] (* x1 x2))))))

(defn -main [& args]
  (println (largest-palindrome 3)))
