(ns evolutive-model.main
  (:require [clojure.spec.alpha :as s])
  (:gen-class))

(s/def ::mes
  (s/and pos-int? (s/int-in 1 13)))

(defn fecha [dia mes anio]
  {:pre [(s/valid? ::mes mes)]}
  {:dia dia :mes mes :anio anio})

(defn mismo-clave [fecha1 fecha2 clave]
  (= (clave fecha1) (clave fecha2)))

(defn puntual [dia mes anio]
  {:pre [(s/valid? ::mes mes)]}
  {:Tipo :Puntual :dia dia :mes mes :anio anio})

(defn anual [dia mes]
  {:Tipo :Anual :dia dia :mes mes})

(defmulti feriado? :Tipo)
(defmethod feriado? :Puntual [p feriado]
   (= p feriado))
(defmethod feriado? :Anual [p feriado]
  (and
   (mismo-clave p feriado :dia)
   (mismo-clave p feriado :mes)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
