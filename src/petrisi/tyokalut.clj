(defn printdenty
  "Auttaa tulostamaan ja palauttamaan arvoja thredingissa:
    (-> dataa
      (map jotain)
      printdenty
      (jotain-muuta nonnoo)
      (printdenty \"debuggia: \"))

  tai
    (->> dataa
        (jotain boo)
        printdenty
        (jotain-muuta nonnoo)
        (printdenty \"debuggia: \"))"
  ([x]
   (printdenty x ""))
  ([x y]
   (let [f (fn [prefix object]
             (println prefix object)
             object)]
     (if (string? x)
       (f x y)
       (f y x)))))

(defn prettydenty
  "Auttaa tulostamaan ja palauttamaan arvoja thredingissa.

  (-> dataa
      (map jotain)
      prettydentity
      (jotain-muuta noo)
      (prettydentity \"debuggia: \"))

  tai:
  (->> dataa
       (jotain blaa)
       prettydentity
       (jotain-muuta boo)
       (prettydentity \"debuggia: \"))"
  ([x]
   (prettydenty x ""))
  ([x y]
   (let [f (fn [prefix object]
             (print prefix)
             (pprint object)
             object)]
     (if (string? x)
       (f x y)
       (f y x)))))
