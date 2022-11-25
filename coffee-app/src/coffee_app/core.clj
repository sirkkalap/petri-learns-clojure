(ns coffee-app.core
  (:require [coffee-app.utils :as utils])
  (:import [java.util Scanner])
  (:gen-class))

(def ^:const price-menu {:latte 0.5 :mocha 0.4})

(def input (Scanner. System/in))

(defn- start-app []
  "Displaying main menu and processing user choices."
  (let [run-application (ref true)]
    (while (deref run-application)
      (println "\n|     Coffee app         |")
      (println "| 1-Menu 2-Orders 3-Exit |\n")
      (let [choice (.nextInt input)]
        (case choice
          1 (show-menu)
          2 (show-orders)
          3 (dosync (ref-set run-application false)))))))
