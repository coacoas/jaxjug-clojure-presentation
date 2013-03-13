(ns jaxjug-clojure-presentation.fact)

(defn factorial [n]
  (loop [cnt n acc 1]
    (if (zero? cnt) acc
      (recur (dec cnt) (* cnt acc)))))

(time (factorial 50M))

(defn factorial-decent [n]
  (reduce * (range 1 (inc n))))

(factorial-decent 50)