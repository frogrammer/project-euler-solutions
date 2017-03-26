(ns project-euler-solutions.core
  (:require [clojure.math.numeric-tower :as math]
            [clojure.spec :as s]
            [clojure.spec.test :as stest]))


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

;; Problem 7 - 10001st prime
(defn is-prime? [num]
  (reduce (fn [bool current] (and bool (not= 0 (mod num current))))
          true
          (range 2 (inc (math/floor (math/sqrt num))))))

(defn find-prime [i-th]
  (nth (filter is-prime? (drop 2 (range))) (dec i-th)))


(s/fdef project-euler-solutions.core/largest-palindrome
  :args (s/and (s/cat :arg int?) #(pos? (:arg %)))
  :ret int?)
(stest/instrument `largest-palindrome)


(defn -main [& args]
  (println (find-prime 10001)))
