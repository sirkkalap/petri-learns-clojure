(ns hello-world.core
  (:gen-class))

(defn greet [name]
  (str "Moikka, " name "!"))

(defn -main [& args]
  (let [args (or args [])
        target (or (first args) "maailma")]
     println (greet target)))
