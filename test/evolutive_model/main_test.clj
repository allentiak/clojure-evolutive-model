(ns evolutive-model.main-test
  (:require [clojure.test :refer :all]
            [clojure.spec.test.alpha :as st]
            [evolutive-model.main :refer :all]
            [evolutive-model.fecha :as f]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(def dic-10-2020
  (puntual 10 12 2020))

(def abril-2-1982
  (desde 2 4 1982))

(def hoy
  (f/fecha 24 8 2020))

(def hoy-abril-2-1982
  (f/fecha 2 4 1982))

(def dic-25
  (anual 25 12))

(def un-domingo
  (f/fecha 6 9 2020))

(def domingo
  (semanal))

(deftest test-feriado-puntual
  (testing "10-12-2020 es feriado puntual"
    (is (not (feriado? dic-10-2020 hoy )))
    (is (feriado? dic-10-2020 dic-10-2020))))

(deftest test-feriado-anual
  (testing "feriado anual"
    (is (not (feriado? dic-25 hoy)))
    (is (feriado? dic-25 dic-25))))

(deftest test-feriado-desde
  (testing "feriado desde"
    (is (feriado? abril-2-1982 hoy))
    (is (not (feriado? abril-2-1982 hoy-abril-2-1982)))))

(deftest test-feriado-puntual-creacion
  (testing "feriado puntual invalido"
   (is (thrown? AssertionError (puntual 1 13 2020)))))

(deftest test-feriado-semanal
  (testing "feriado semanal"
    (is (feriado? domingo un-domingo))
    (is (not (feriado? domingo hoy)))))

(deftest test-check
  (is (=
       (st/summarize-results (st/check `f/fecha))
       {:total 1, :check-passed 1})))
