(def base-co2 382)
(def base-year 2006)

(defn meditate [s calm]
  (println "Clojure Meditate v2021-08-04")
  (if calm
    (println (clojure.string/capitalize s))
    (println (clojure.string/upper-case s) "!"))
  )

(meditate "in calmness lies true pleasure" true)
(meditate "in calmness lies true pleasure" false)

(defn square
  "Returns the product of `x` with itself."
  [x]
  (* x x))

(square 2)
;(ns user)
;(doc A01/square)
;(square *1)

(defn co-emissions1 "a" [year]
  (let [year-diff (- year base-year)]
    (+ base-co2 (* year-diff 2))))

(defn co-emissions2 "a" [year]
  (let [year-diff (- year base-year)]
    (+ base-co2 (* year-diff 2))))


(co-emissions1 2050)

(co-emissions2 2050)

(let [x 55]
  (if (or (<= 1 x 100) (= 0 (mod x 100)))
    (println "Valid")
    (println "Invalid")))

(let [x 200]
  (println (if (or (<= 1 x 100) (= 0 (mod x 100))) "Valid" "Invalid")))

(defn meditate2
  "Prints a transformation of the string `s` based on the number `calmness-level`"
  [s calmness-level]
   (println "Clojure Meditate v2021-08-04-22-17")
   (if (< calmness-level 5)
     (str (clojure.string/upper-case s) ", I TELL YA!")
     (if (<= 5 calmness-level 9)
        (clojure.string/capitalize s)
        (if (= calmness-level 10)
          (clojure.string/reverse s)
          nil)
        )))

(meditate2 "Trance is not my thing" 1)
(meditate2 "What we do now echoes in eternity" 5)
(meditate2 "Saippuakauppias" 10)
(meditate2 "Saippuakauppias" 11)

(defn i [x] x)
(i 1)

(defn meditate3
  "Prints a transformation of the string `s` based on the number `calmness-level`"
  [s calmness-level]
  (println "Clojure Meditate v2021-08-04-22-17")
  (cond
    (< calmness-level 5)    (str (clojure.string/upper-case s) ", I TELL YA!")
    (<= 5 calmness-level 9) (clojure.string/capitalize s)
    (= calmness-level 10)   (clojure.string/reverse s)
    ))

(meditate3 "Trance is not my thing" 1)
(meditate3 "What we do now echoes in eternity" 5)
(meditate3 "Saippuakauppias" 10)
(meditate3 "Saippuakauppias" 11)

"I am immutable"

"\"The measure of intelligence is the ability to change\""

(def silly-string "I am immutable. I am a silly string")
(clojure.string/replace silly-string "silly" "clever")
silly-string

(first "a collection of characters")
;(type *1)

(str "That's the way you " "con" "cate" "nate")

;(str *1 " - " silly-string)

;(dir clojure.string)

(type 10000000000000000000)

5/4

(type (/ 3 4))
(type (/ 4 4))
(type 1.2)
(println Math/PI)
(Math/random)
(Math/sqrt 9)
(Math/round 0.7)

;(doc clojure.string/replace)
(clojure.string/replace "Hello, World" #"\w" (fn [letter] (do (println letter) "!")))
(int \a)
(first (char-array "a"))
(Math/pow (int (first (char-array "a"))) 2)

(defn encode-letter
  [s x]
  (let [code (Math/pow (+ x (int (first (char-array s)))) 2)]
    (str "#" (int code))))

(encode-letter "a" 4)

(defn encode
  [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\w" (fn [s] (encode-letter s number-of-words)))))

(encode "Hello, World")

(defn decode-letter
  [s y]
  (let [number (Integer/parseInt (subs s 1))
        letter (char (- (Math/sqrt number) y))]
    (str letter)))

(decode-letter "#10201" 4)

(defn decode [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\#\d+" (fn [s] (decode-letter s number-of-words)))))

(encode "If you want to keep a secret, you must also hide it from yourself.")
;(decode *1)

; Keywords
:foo
:another_keyword

; HashMaps
{:artist "David Bowtie" :song "The Man Who Mapped the World" :year 1970}
{:artist "David Bowtie", :song "Comma Oddity", :year 1969}

{
 "David Bowtie" {
                 "The Man Who Mapped the World" {:year 1970, :duration "4:01"}
                 "Comma Oddity"                 {:year 1969, :duration "5:19"}
                 }
 "Crosby Stills Hash" {
                       "Helplessly Mapping" {:year 1970, :duration "2:38"}
                       "Almost Cut my Hair" {:year 1970, :duration "4:29", :featuring ["Neil Young",
                                                                                       "Rich Hickey"]}
                       }
 }

(hash-map :a 1 :b 2 :c 3)

(def favorite-fruit {:name "Kiwi", :color "Green", :kcal_per_100g 61 :distinguish_mark "Hairy"})
(get favorite-fruit :name)
(get favorite-fruit :color)
(get favorite-fruit :taste "Very good 8/10")
(favorite-fruit :color)
(:color favorite-fruit)
(favorite-fruit :shape "egg-like")
(assoc favorite-fruit :shape "egg-like")
(println favorite-fruit)
(assoc favorite-fruit :color "Brown")
(println favorite-fruit)
(assoc favorite-fruit :yearly_production_in_tonnes {:china 2025000 :italy 541000 :new_zealand 412000 :iran 311000 :chile 225000})
(assoc favorite-fruit :kcal_per_100g (- (:kcal_per_100g favorite-fruit) 1))
(update favorite-fruit :kcal_per_100g dec)
(update favorite-fruit :kcal_per_100g - 10)
(dissoc favorite-fruit :distinguish_mark)
(dissoc favorite-fruit :kcal_per_100g :color)

; HashSets
#{1 2 3 4 5}
#{:a :a :b :c}
(hash-set :a :b :c :d)
(set [:a :b :c])
(set ["No" "Copy" "Cats" "Cats" "Please"])
(sorted-set "No" "Copy" "Cats" "Cats" "Please")

(def supported-currencies #{"Dollar" "Japanese yen" "Euro" "Indian rupee" "British pound"})
(get supported-currencies "Dollar")
(contains? supported-currencies "Dollar")
(supported-currencies "Swiss franc")
("Dollar" supported-currencies)                             ; Exception
(conj supported-currencies "Monopoly Money")
(conj supported-currencies "Monopoly Money" "Gold dragon" "Gil")
(disj supported-currencies "Dollar" "British pound")
;(dir clojure.set)
(conj '(1 2) 3)
(disj '(1 2 3) 2)                                           ; Exception

; Vectors
[1 2 3]
(vector 10 15 2 15 0)
[nil :keyword "String" {:answers [:yep :nope]}]
(get [:a :b :c] 0)
(get [:a :b :c] 2)
(get [:a :b :c] 10)
(def fibonacci [0 1 1 2 3 5 8])
(get fibonacci 6)
(fibonacci 6)
(conj fibonacci 13 21)
(let [size (count fibonacci)
  last-number (last fibonacci)
  second-to-last-number (fibonacci (- size 2))]
  (conj fibonacci (+ last-number second-to-last-number)))
(1 2 3)                                                     ; Exception
'(+ 1 2 3)
(list :a :b :c)
(first '(:a :b :c :d))
(rest '(:a :b :c :d))
(nth '(:a :b :c :d) 2)
(def my-todo (list "Feed the cat" "Clean the bathroom" "Save the world"))
(conj my-todo "Go to work")
(conj my-todo "Go to work" "Wash my socks")
(first my-todo)
(rest my-todo)
(nth my-todo 2)

; Collections
(def language {:name "Clojure" :creator "Rich Hickey" :platforms ["Java" "JavaScript" ".Net"]})
(count language)
(count #{})
(empty? [])
(seq language)
(nth (seq language) 1)
(first #{:a :b :c})
(rest #{:a :b :c})
(last language)
(into #{1 2 3 4} [5 6 7 8])
(vec (into #{} [1 2 3 3 3 4]))
(into {} [[:a 1] [:b 2] [:c 3]])
(into '() [1 2 3 4])
(concat '(1 2) '(3 4))
(into '(1 2) '(3 4))
(concat #{1 2 3} #{1 2 3 4})
(concat {:a 1} ["Hello"])
(def alphabet #{:a :b :c :d :e :f})
alphabet
(sort alphabet)
(sort [3 7 5 1 9])
; (into [] *1)
(conj language [:created 2007])
(assoc [:a :b :c :d] 2 :z)

; Excercise 2.06 Working with Nested Data Structures
(def gemstone-db {
                  :ruby {
                         :name "Ruby"
                         :stock 120
                         :sales [1990 3644 6376 4918 7882 6747 7495 8573 5097 1712]
                         :properties {
                                      :dispersion 0.018
                                      :hardness 9.0
                                      :refractive-index [1.77 1.78]
                                      :color "Red"
                                      }
                         }
                  :diamond {
                            :name "Diamond"
                            :stock 10
                            :sales [8295 329 5960 6118 4189 3436 9833 8870 9700 7182 7061 1579]
                            :properties {
                                         :dispersion 0.044
                                         :hardness 10
                                         :refractive-index [2.417 2.419]
                                         :color "Typically yellow, brown or gray to colorless"
                                         }
                            }
                  :moissanite {
                               :name "Moissanite"
                               :stock 45
                               :sales [7761 3220]
                               :properties {
                                            :dispersion 0.104
                                            :hardness 9.5
                                            :refractive-index [2.65 2.69]
                                            :color "Colorless, green, yellow"
                                            }
                               }
                  }
  )

(get (get (get gemstone-db :ruby) :properties) :hardness)
(:hardness (:properties (:ruby gemstone-db)))
(get-in gemstone-db [:ruby :properties :hardness])

(defn durability
  [db gemstone]
  (get-in db [gemstone :properties :hardness]))

(durability gemstone-db :ruby)
(durability gemstone-db :moissanite)
; Change the color property of a gem

; Failure, other properties lost
(assoc (:ruby gemstone-db) :properties
   {:color "Near colorless through pink through all shades of red to a deep crimson"})
; Remember into and update
(into {:a 1 :b 2} {:c 3})

; Failure, only ruby is returned, not a complete db
; (can also be hard to read and understand what that does)
(update (:ruby gemstone-db) :properties
        into {:color "Near colorless through pink through all shades of red to a deep crimson"})

(assoc-in gemstone-db [:ruby :properties :color]
          "Near colorless through pink through all shades of red to a deep crimson")
;(pprint *1)
(defn change-color
  [db gemstone new-color]
  (assoc-in db [gemstone :properties :color] new-color))
(change-color gemstone-db :ruby
              "Near colorless through pink through all shades of red to a deep crimson")
(update-in gemstone-db [:diamond :stock] dec)
;(set! *print-level* 2)
;(set! *print-level* nil)
(update-in gemstone-db [:diamond :sales] conj 999)
(defn sell
  [db gemstone client-id]
  (let [clients-updated-db
        (update-in db [gemstone :stock] dec)]
    (update-in clients-updated-db [gemstone :sales] conj client-id)))
(sell gemstone-db :diamond 999)
(sell gemstone-db :moissanite 123)

; Activity 2.01: Creating a Simple In-Memory Database

(def demo-db
  {:clients {:data [{:id 1 :name "Bob" :age 30} {:id 2 :name "Alice" :age 24}]:indexes {:id {1 0, 2 1}}},:fruits {:data [{:name "Lemon" :stock 10} {:name "Coconut" :stock 3}]:indexes {:name {"Lemon" 0, "Coconut" 1}}},:purchases {:data [{:id 1 :user-id 1 :item "Coconut"} {:id 1 :user-id 2 :item "Lemon"}]:indexes {:id {1 0, 2 1}}}})

(def memory-db (atom {}))
(defn read-db [] @memory-db)
(defn write-db [new-db] (reset! memory-db new-db))

(defn create-table
  [table-name]
  (let [db (read-db)]
    (write-db (assoc db table-name {:data [] :indexes {}}))))
; Test
(create-table :foo)

(defn drop-table
  [table-name]
  (let [db (read-db)]
    (write-db (dissoc db table-name))))
; Test
(drop-table :foo)

; Examine demo-db
((get-in demo-db [:clients :indexes :id]) 2)
((get-in demo-db [:clients :data]) ((get-in demo-db [:clients :indexes :id]) 2))

(defn insert-no-check
  [table-name record id-key]
  (let [db (read-db)
        new-db (update-in db [table-name :data] conj record)
        index (- (count (get-in new-db [table-name :data])) 1)]
    (write-db
      (update-in new-db [table-name :indexes id-key] assoc (id-key record) index))))
; Test
(insert-no-check :bar {:id 1 :name "Jaska"} :id)

(defn select-*
  [table-name]
  (get-in (read-db) [table-name :data]))
; Test
(select-* :bar)

(defn select-*-where
  [table-name field field-value]
  (let [db (read-db)
        index (get-in db [table-name :indexes field field-value])
        data (get-in db [table-name :data])]
    (get data index)))
; Test
(select-*-where :bar :id 1)

(defn insert
  [table-name record id-key]
  (if-let [existing-record (select-*-where table-name id-key (id-key record))]
    (println (str "Record with" id-key ": " (id-key record) " already exists. Aborting"))
    (insert-no-check table-name record id-key)))

(insert :bar {:id 1 :name "Jaska"} :id)

; 3 Functions in Depth
(defn print-coords [coords]
  (let [lat (coords 0)
        lon (coords 1)]
    (println (str "Latitude: " lat " - " "Longitude: " lon))))
(print-coords [48.44 22.21 102])

(defn print-coords2 [coords]
  (let [[lat lon alt] coords]
    (if alt
      (println (str "Latitude: " lat " - " "Longitude: " lon " - Altitude: " alt))
      (println (str "Latitude: " lat " - " "Longitude: " lon)))))
(print-coords2 [48.23 12.2 100])
(print-coords2 [48.23 12.2])

(defn print-icao-cords1 [airport]
  (let [{lat :lat lon :lon icao :icao} airport]
    (println (str icao " is located at Latitude: " lat " - " "Longitude: " lon))))

(defn print-icao-cords2 [airport]
  (let [{:keys [lat lon icao]} airport]
    (println (str icao " is located at Latitude: " lat " - " "Longitude: " lon))))
(print-icao-cords2 {:lat 44.4 :lon 12.2 :icao "EDDA"})

; Sequential Destructuring

(def booking [1425, "Bob Smith", "Allergic to unsalted peanuts only", [[48.9615, 2.4372], [37.742, -25.6976]], [[37.742, -25.6976], [48.9615, 2.4372]]])

(let [[id customer-name sensitive-info flight1 flight2 flight3] booking]
  (println id customer-name flight1 flight2 flight3))

(defn print-flight [flight]
  (let [[departure arrival] flight
        [lat1 lon1] departure
        [lat2 lon2] arrival]
    (println (str "Flying from: Lat " lat1 " Lon " lon1
                  " Flying to: Lat " lat2 " Lon " lon2))))

(let [big-booking (conj booking [[37.742, -25.6976], [51.1537, 0.1821]]
                        [[51.1537, 0.1821], [48.9615, 2.4372]])
      [_ customer-name _ & flights] big-booking]
  (println customer-name " booked " (count flights) " flights."))

(print-flight [[48.9615, 2.4372], [37.742 -25.6976]])

(defn print-booking [booking]
  (let [[_ customer-name _ & flights] booking]
    (println (str customer-name " booked " (count flights) " flights."))
    (let [[flight1 flight2 flight3] flights]
      (when flight1 (print-flight flight1))
      (when flight2 (print-flight flight2))
      (when flight3 (print-flight flight3)))))

(print-booking booking)

; Associative destructuring

(def mapjet-booking
  {
   :id 8773
   :customer-name "Alice Smith"
   :catering-notes "Vegetarian on Sundays"
   :flights [
             {
              :from {:lat 48.9615 :lon 2.4372 :name "Paris Le Bourget Airport"},
              :to {:lat 37.742 :lon -25.6976 :name "Ponta Delgada Airport"}},
             {
              :from {:lat 37.742 :lon -25.6976 :name "Ponta Delgada Airport"},
              :to {:lat 48.9615 :lon 2.4372 :name "Paris Le Bourget Airport"}}
             ]
   })

;(let )

(let [{:keys [customer-name flights]} mapjet-booking]
  (println customer-name "booked" (count flights) "flights"))

(defn print-mapjet-flight
  [flight]
  (let [{:keys [from to]} flight
        {lat1 :lat lon1 :lon} from
        {lat2 :lat lon2 :lon} to]
    (println (str "Flying from: Lat " lat1 " Lon " lon1 " to Lat " lat2 " Lon " lon2))))

(defn print-mapjet-flight2
  [flight]
  (let [{{lat1 :lat lon1 :lon} :from,
         {lat2 :lat lon2 :lon} :to} flight]
    (println (str "Flying from: Lat " lat1 " Lon " lon1 " to Lat " lat2 " Lon " lon2))))
(print-mapjet-flight (first (:flights mapjet-booking)))
(print-mapjet-flight2 (first (:flights mapjet-booking)))

(with-out-str (print "kekek" (+ 1 1)))

(defn print-mapjet-booking
  [booking]
  (let [{:keys [customer-name flights]} booking]
    (println (str customer-name " booked " (count flights) " flights."))
    (let [[flight1 flight2 flight3] flights]
      (when flight1 (print-mapjet-flight2 flight1))
      (when flight2 (print-mapjet-flight2 flight2))
      (when flight3 (print-mapjet-flight2 flight3)))))

(print-mapjet-booking mapjet-booking)

; Destructuring Function Parameters

(defn print-flight3
  [[[lat1 lon1] [lat2 lon2]]]
  (println (str "Flying from: Lat " lat1 " Lon " lon1 " to Lat " lat2 " Lon " lon2)))

(let [[_ _ _ & flights] booking] (print-flight3 (first flights)))

; Arity Overloading

(defn no-overloading []
  (println "Same old, same old..."))

(defn overloading
  ([] "No argument")
  ([a] (str "One argument: " a))
  ([a b] (str "Two arguments: a: " a " b: " b)))

(overloading)
(overloading 1)
(overloading 1 2)
(overloading 1 2 3)                                         ; Exception

(def weapon-damage {:fists 10 :staff 35 :sword 100 :cast-iron-saucepan 150})
(defn strike
  ([enemy] (strike enemy :fists))
  ([enemy weapon]
   (let [damage (weapon weapon-damage)]
     (update enemy :health - damage))))

(strike {:name "n00b-hunter" :health 100})
(strike {:name "n00b-hunter" :health 100} :sword)
(strike {:name "n00b-hunter" :health 100} :cast-iron-saucepan)

; Variadic Functions
(str "Concatenating " "is " "difficult " "to " "spell " "but " "easy " "to " "use!")

(defn welcome
  [player & friends]
  (println (str "Welcome to the Parenthmazes " player "!"))
  (when (seq friends)
    (println (str "Sending " (count friends)
                  " friend request(s) tot the following players: "
                  (clojure.string/join ", " friends)))))

(welcome "Jon")
(welcome "Jon" "Arya" "Tyrion" "Petyr")

(defn welcome
  ([player] (println (str "Welcome to the Parenthmazes " player "!")))
  ([player & friends] (println (str "Sending " (count friends)
                                    " friend request(s) tot the following players: "
                                    (clojure.string/join ", " friends)))))
(welcome "Jon")
(welcome "Jon" "Arya" "Tyrion" "Petyr")

(doc welcome)

; Exercise 3.03: Multi-arity and Destructuring with Parenthmazes
(def weapon-damage {:fists 10.0 :staff 35.0 :sword 100.0 :cast-iron-saucepan 150.0})
(defn strike
  "Strike function that handles healing when the enemy is in the same camp as us"
  ([target weapon]
   (let [points (weapon weapon-damage)]
     (if (= :gnomes (:camp target))
       (update target :health + points)
       (update target :health - points)))))
(def enemy {:name "Zulkaz", :health 150.0, :camp :trolls})
(strike enemy :sword)
(def ally {:name "Carla" :health 115.0 :camp :gnomes})
(strike ally :staff)
(defn strike
  "As above, but now with armor"
  ([target weapon]
   (let [points (weapon weapon-damage)]
     (if (= :gnomes (:camp target))
       (update target :health + points)
       (let [armor (or (:armor target) 0)
             damage (* points (- 1 armor))]
         (update target :health - damage))))))
(strike enemy :cast-iron-saucepan)
(def enemy {:name "Zulkaz" :health 220.0 :armor 0.8 :camp :trolls})
(strike enemy :cast-iron-saucepan)

(defn strike
  "Now with associative destructuring and :as binding of `target`"
  ([{:keys [camp armor] :as target} weapon]
   (let [points (weapon weapon-damage)]
     (if (= :gnomes camp)
       (update target :health + points)
       (let [damage (* points (- 1 (or armor 0)))]
         (update target :health - damage))))))

(strike enemy :cast-iron-saucepan)
(defn strike
  "With one argument, strike a target with a default :fists `weapon`. With two argument, strike a target with `weapon`.
   Strike will heal a target that belongs to the gnomes camp."
  ([target] (strike target :fists))
  ([{:keys [camp armor], :or {armor 0}, :as target} weapon]
   (let [points (weapon weapon-damage)]
     (if (= :gnomes camp)
       (update target :health + points)
       (let [damage (* points (- 1 armor))]
         (update target :health - damage))))))

(strike enemy)
(strike enemy :cast-iron-saucepan)
(strike ally :staff)

; Higher order functions
(update {:item "Tomato" :price 1.0} :price / 2)
(update {:item "Tomato" :fruit false} :fruit not)

(defn operate [f x] (f x))
(operate inc 2)
(defn operate [f x] (let [oldoperate operate]
                      (println (str "operate f: " f " x:" x))
                      ( oldoperate f x )))
(operate inc 2)                                             ; Stack overflow

(defn operate [f & args] (f args))
(operate + 1 2 3)                                           ; Exception
(+ [1 2 3])                                                 ; Same exception
(apply + [ 1 2 3])
(defn operate [f & args] (apply f args))
(operate + 1 2 3)
( operate str "It " "Should " "Concatenate!")
(defn random-fn [] (first (shuffle [+ - * /])))
(operate (random-fn) 2 3)
(fn? random-fn)
(fn? (random-fn))

(let [mysterious-fn (random-fn)]
  (mysterious-fn 2 3))

; Partial

(def marketing-adder (partial + 0.99))
(marketing-adder 10 5)

(def format-price (partial str "€"))
(format-price "100")
(format-price 10 50)

; Compose
(let [a 1] (println a) (println " :)"))

(defn sample [coll] (first (shuffle coll)))

(sample [1 2 3])

(def sample (comp first shuffle))

((comp inc * ) 2 2 )
((comp * inc) 2 2 )                                         ;ArityException

(def checkout (comp (partial str "Only ") format-price marketing-adder))
(checkout 12 234 23 5)



