(ns jaxjug-clojure-presentation.fizzbuzz
  (:require [clojure.string :as cs]))

(defn divisible-by? [n] 
  #(zero? (rem % n)))

(defn string-if [str cond?] 
  #(if (cond? %) 
    str 
    nil))

(defn num-to-string [to-strings n]
  (let [result (cs/join (map #(% n) to-strings))]
    (if (empty? result)
      n
      result)))

(def fizz (string-if "fizz" (divisible-by? 3)))
(def buzz (string-if "buzz" (divisible-by? 5)))

(defn fizzbuzz 
  ([end] (fizzbuzz 1 end))
  ([start end]
    (map 
      (partial num-to-string [fizz buzz]) 
      (range start end))))

(defn -main
  "FizzBuzz."
  [x]
  (println (fizzbuzz (Integer/parseInt x))))
