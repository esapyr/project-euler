(ns proj-euler-clj.core)

(def problem1(reduce +
               (map (fn [x]
                 (if (or
                    (= (mod x 5) 0)
                    (= (mod x 3) 0))
                   x 0))
               (range 1000))))

(defn fib [a b] (cons a (lazy-seq (fib b (+ b a)))))

(def problem2
  (reduce +
       (take-while (partial >= 4000000) (filter even? (fib 1 1)))))

(defn solved? [computed answer]
  (if (= computed answer)
    "solved"
    "not solved"))

(defn -main []
  (do
    (println problem1 (solved? problem1 233168))
    (println problem2 (solved? problem2 4613732))))

