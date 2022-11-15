(ns ex8.core
  (:require [java-time :as time]))

(defn -main
  "Display current local time"
  [& args]
  (println (time/local-time)))
