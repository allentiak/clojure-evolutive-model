(ns evolutive-model.main-test
  (:require [clojure.test :refer :all]
            [evolutive-model.main :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(def dic-10-2020
  {:dia 10 :mes 12 :anio 2020})

(deftest feriado-puntual
  (testing "10-12-2020 es feriado puntual"
    (is (es-feriado? dic-10-2020 [{:dia 10 :mes 12 :anio 2020}]))))
