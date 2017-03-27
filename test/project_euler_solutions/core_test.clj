(ns project-euler-solutions.core-test
  (:require [clojure.test :refer :all]
            [project-euler-solutions.core :refer :all]))

(deftest is-palindrome?-true-test
  (testing "true cases"
    (are [x] (= true x)
         (is-palindrome? 0)
         (is-palindrome? 101)
         (is-palindrome? 99099))))

(deftest is-palindrome?-false-test
  (testing "false cases"
    (are [x] (= false x)
         (is-palindrome? 10)
         (is-palindrome? 5101)
         (is-palindrome? 9915099))))

(deftest largest-palindrome-test
    (are [x y] (= x y)
         9 (largest-palindrome 1)
         9009 (largest-palindrome 2)
         906609 (largest-palindrome 3)))

(deftest is-prime?-true-test
  (testing "true cases"
    (are [x] (= true x)
         (is-prime? 2)
         (is-prime? 503)
         (is-prime? 104743))))

(deftest is-prime?-false-test
  (testing "false cases"
    (are [x] (= false x)
         (is-prime? 4)
         (is-prime? 504)
         (is-prime? 100000))))

(deftest find-prime-test
    (are [x y] (= x y)
         2 (find-prime 1)
         541 (find-prime 100)
         104743 (find-prime 10001)))
