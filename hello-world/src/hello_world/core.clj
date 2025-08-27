(ns hello-world.core
    (:gen-class))

(defn greet [name]
      (str "Moikka, " name "!"))

(defn -main [& args]
      ;; Jos annetaan nimi komentoriviltä, käytetään sitä, muuten "maailma"
      (let [target (or (first args) "maailma")]
           (println (greet target))))
