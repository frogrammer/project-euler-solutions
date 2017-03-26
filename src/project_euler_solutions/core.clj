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

(s/fdef project-euler-solutions.core/largest-palindrome
  :args (s/and (s/cat :arg int?) #(pos? (:arg %)))
  :ret int?)
(stest/instrument `largest-palindrome)

(defn -main [& args]
  (println (largest-palindrome 3)))
