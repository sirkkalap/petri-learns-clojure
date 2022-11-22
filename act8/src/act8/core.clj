(ns act8.core
  (:gen-class)
  (:require [cheshire.core :as json]))

(defn generate-hash-from-json [json]
  (json/parse-string json))

(defn generate-json-from-hash [hash]
  (json/generate-string hash))
