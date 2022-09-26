(ns (:use clojure.test))
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

; Anonymous function literal #() (Use sparingly because numbered parameters hinder reading.)

(fn [s] (str "Hello " s))
#(str "Hello " %)
(fn [x y] (* (+ x 10) (+ y 20)))
#(* (+ %1 10) (+ %2 20))
(#(str %1 " " %2 " " %3) "First" "Second" "Third")

; Exercise 3.04: High-Order Functions with Parenthmazes

(def weapon-fn-map
  {:fists (fn [health] (if (< health 100) (- health 10) health))})
((weapon-fn-map :fists) 150)
((weapon-fn-map :fists) 50)

(def weapon-fn-map
  {
   :fists (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   })

((weapon-fn-map :staff) 150)
(def weapon-fn-map
  {
   :fists (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   :sword #(- % 100)
   })

((weapon-fn-map :sword) 150)

(def weapon-fn-map
  {
   :fists (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   :sword #(- % 100)
   :cast-iron-saucepan #(- % 100 (rand-int 50))
   })

((weapon-fn-map :cast-iron-saucepan) 200)

(source identity)

(def weapon-fn-map
  {
   :fists (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   :sword #(- % 100)
   :cast-iron-saucepan #(- % 100 (rand-int 50))
   :sweet-potato identity
   })

(defn strike
  "With one argument, strike a target with a default :fists `weapon`. With tro argument, strike a target with `weapon` and returnthe target entity"
  ([target] (strike target :fists))
  ([target weapon]
   (let [weapon-fn (weapon weapon-fn-map)]
     (update target :health weapon-fn))))

(def enemy {:name "Arnold", :health 250})
(strike enemy :sweet-potato)
(strike enemy :sword)
(strike enemy :cast-iron-saucepan)
(strike (strike enemy :sword) :cast-iron-saucepan)

(update enemy :health (comp (:sword weapon-fn-map) (:cast-iron-saucepan weapon-fn-map)))

(defn mighty-strike
  "Strike a `target` with all weapons!"
  [target]
  (let [weapon-fn (apply comp (vals weapon-fn-map))]
    (update target :health weapon-fn)))

(mighty-strike enemy)

; Multimethods (Polymorphism)

(defmulti strike (fn [m] (get m :weapon)))
(defmulti strike :weapon) ;Returns nil because namespace has strike multi mapped
(ns-unmap 'user 'strike) ; Unlike normal defs multimethods do not overwrite
(defmulti strike :weapon)
(defmethod strike :sword
  [{{:keys [:health]} :target}]
  (- health 100))

(defmethod strike :cast-iron-saucepan
  [{{:keys [:health]} :target}]
  (- health 100 (rand-int 50)))

(strike {:weapon :sword :target {:health 200}})
(strike {:weapon :cast-iron-saucepan :target {:health 200}})
(strike {:weapon :spoon :target {:health 200}})             ;IllegalArgumentException

(defmethod strike :default [{{:keys [:health]} :target}] health)

(strike {:weapon :spoon :target {:health 200}})

(ns-unmap 'user 'strike)

(defmulti strike (fn
                   [{{:keys [:health]} :target weapon :weapon}]
                   (if (< health 50) :finisher weapon)))
(defmethod strike :finisher [_] 0)
(defmethod strike :sword
  [{{:keys [:health]} :target}]
  (- health 100))
(defmethod strike :default [{{:keys [:health]} :target}] health)
(strike {:weapon :sword :target {:health 200}})
(strike {:weapon :spoon :target {:health 30}})

; Excercise 3.05: Using Multimethods
(def player {:name "Lea" :health 200 :position {:x 10 :y 10 :facing :north}})
(defmulti move #(:facing (:position %)))
(ns-unmap 'user 'move)
(defmulti move (comp :facing :position)) ; comp is so much better here
(defmethod move :north [entity]
  (update-in entity [:position :y] inc))
(defmethod move :south [entity]
  (update-in entity [:position :y] dec))
(defmethod move :west [entity]
  (update-in entity [:position :x] inc))
(defmethod move :east [entity]
  (update-in entity [:position :x] dec))
(defmethod move :default [entity] entity)

; Testing
(move player)
(move {:position {:x 10 :y 10 :facing :west}})
(move {:position {:x 10 :y 10 :facing :wall}})

; Activity 3.01: Building a Distance and Cost Calculator
(defn itinerary
  [{:keys [from to transport vehicle]}]
  (let [d 1
        c 1
        dur 1]
    {:distance d :cost c :duration dur}))

; Testing
(let [exp1 {:distance 1 :cost 10 :duration 1}
      travel1 {:from {:lat 1 :lon 1} :to {:lat 2 :lon 2} :transport :foo :vehicle :car}]
  (clojure.test/is (= exp1 (itinerary travel1))))

; 4. Mapping and Filtering
(map inc [1 2 3])

; Ex 4.01 Working with map
(map (fn [i] (* i 10)) [1 2 3 4 5])

(map count ["Let's" "measure" "word" "length" "now"])
(map (fn [w] (str w ": " (count w))) ["Let's" "measure" "word" "length" "now"])

(filter keyword? ["a" :b "c" :d "e" :f "g"])

; Ex 4.02 Getting Started with filter
(odd? 5)
(odd? 6)

(filter odd? [1 2 3 4 5])
(remove odd? [1 2 3 4 5])
(filter (constantly true) [1 2 3 4 5])
(filter (constantly false) [1 2 3 4 5])

(take 3 [1 2 3 4 5])
(drop 3 [1 2 3 4 5])

(take-while #(> 10 %) [2 9 4 12 3 99 1])
(drop-while #(> 10 %) [2 9 4 12 3 99 1])

; Ex 4.03 Partitioning a Sequence with take-while and drop-while
(def students [{:name "Eliza" :year 1994}
               {:name "Salma" :year 1995}
               {:name "Jodie" :year 1997}
               {:name "Kaitlyn" :year 2000}
               {:name "Alice" :year 2001}
               {:name "Pippa" :year 2002}
               {:name "Fleur" :year 2002}])

(take-while #(< (:year %) 2000) students)
(drop-while #(< (:year %) 2000) students)

; Using map and filter Together
(map (fn [n] (* 10 n))
  (filter odd? [1 2 3 4 5]))

; With threading
(def filtered (filter odd? [1 2 3 4 5]))
(->> [1 2 3 4 5]
  (filter odd?)
  (map (fn [n] (* 10 n))))

; Using Lazy Sequences
(range 1 6)
(def our-seq (range 100))

; Ex 4.04: Watching Lazy Evaluation

(defn our-range [limit]
  (take-while #(< % limit) (iterate inc 0)))

(our-range 5)

(map #(* 10 %) (our-range 5))
(map (fn [i] (print ".") (* i 10)) (our-range 5))

; use def to store the lazy sequence, instead of viewing it in the REPL:
(def by-ten (map (fn [i] (print ".") (* i 10)) (our-range 5)))
; by-ten

(->> (range)
  (map #(* 10 %))
  (take 5))

; Ex 4.05: Creating Our Own Lazy Sequence
(def our-randoms (repeatedly (partial rand-int 100)))
(take 20 our-randoms)
(defn some-random-integers [size]
  (take size (repeatedly (fn [] (rand-int 100)))))
(some-random-integers 12)

; Anonymous Functions

; Ex 4.06: Extracting Data from a List of Maps
(def game-users
  [{:id 9342
    :username "speedy"
    :current-points 45
    :remaining-lives 2
    :experience-level 5
    :status :active}
   {:id 9854
    :username "stealthy"
    :current-points 1201
    :remaining-lives 1
    :experience-level 8
    :status :speed-boost}
   {:id 3014
    :username "sneaky"
    :current-points 725
    :remaining-lives 7
    :experience-level 3
    :status :active}
   {:id 2051
    :username "forgetful"
    :current-points 89
    :remaining-lives 4
    :experience-level 5
    :status :imprisoned}
   {:id 1032
    :username "wandering"
    :current-points 2043
    :remaining-lives 12
    :experience-level 7
    :status :speed-boost}
   {:id 7213
    :username "slowish"
    :current-points 143
    :remaining-lives 0
    :experience-level 1
    :status :speed-boost}
   {:id 5633
    :username "smarter"
    :current-points 99
    :remaining-lives 4
    :experience-level 4
    :status :terminated}
   {:id 3954
    :username "crafty"
    :current-points 21
    :remaining-lives 2
    :experience-level 8
    :status :active}
   {:id 7213
    :username "smarty"
    :current-points 290
    :remaining-lives 5
    :experience-level 12
    :status :terminated}
   {:id 3002
    :username "clever"
    :current-points 681
    :remaining-lives 1
    :experience-level 8
    :status :active}])
(map (fn [player] (:current-points player)) game-users)
(map :current-points game-users)

; Sets as Predicates
(def alpha-set (set [:a :b :c]))
(alpha-set :z)
(alpha-set :a)

(hash-set :a :b :c)
(def animal-names ["turtle" "horse" "cat" "frog" "hawk" "worm"])
(remove (fn [animal-name]
          (or (= animal-name "horse")
            (= animal-name "cat")))
  animal-names)
(remove #{"horse" "cat"} animal-names)

; Filtering on a Keyword with comp and a Set
(require '[clojure.string :as string])
(defn normalize [s] (string/trim (string/lower-case s)))
(def normalizer (comp string/trim string/lower-case))
(normalizer "  Some Information ")
(def remove-words #{"and" "an" "a" "the" "of" "is"})
(remove (comp remove-words string/lower-case string/trim) ["February" " THE " "4th"])

; Ex 4.07: Using comp and a Set to Filter on a Keyword
(map :current-score game-users)
(map :current-points game-users)
(def keep-statuses #{:active :imprisoned :speed-boost})
(filter (fn [player] (keep-statuses (:status player))) game-users)

(->> game-users
  (filter (comp #{:active :imprisoned :speed-boost} :status))
  (map :current-points))

; Returning a List Longer than the Input with mapcat
(def alpha-lc [ "a" "b" "c" "d" "e" "f" "g" "h" "i" "j"])
(mapcat (fn [letter] [letter (clojure.string/upper-case letter)]) alpha-lc)

; Mapping with Multiple Inputs
(map (fn [a b] (+ a b)) [5 8 3 1 2] [5 2 7 9 8])
(defn our-zipmap [xs ys]
  (->> (map (fn [x y] [x y]) xs ys)
    (into {})))
(our-zipmap [:a :b :c] [1 2 3])

; Tuples
(def meals ["breakfast" "lunch" "dinner" "midnight snack"])
(map (fn [idx meal] (str (inc idx) ". " meal)) (range) meals)
(map-indexed (fn [idx meal] (str (inc idx) ". " meal)) meals)

; Ex 4.08: Identifying Weather Trends
(def temperature-by-day
  [18 23 24 23 27 24 22 21 21 20 32 33 30 29 35 28 25 24 28 29 30])
(map (fn [td yd] (cond
                   (< td yd) :colder
                   (> td yd) :warmer
                   :else :unchanged)) (drop 1 temperature-by-day) temperature-by-day)

; Consuming Extracted Data with apply
(apply max [2 3 7])
(let [a 5
      b nil
      c 18]
  (+ a b c)) ; => NPE
(let [a 5
      b nil
      c 18]
  (apply + (filter integer? [a b c]))) ; Filter nil
(apply min 0 [])

; Ex 4.09: Finding the Average Weather Temperature
(let [tot (apply + temperature-by-day)
      c (count temperature-by-day)]
  (/ tot c))

; Activity 4.01: Using map and filter to Report Summary Information
(defn min-max
  "Returns the least and the greatest of the nums."
  ([x] [x x])
  ([x y] [(. clojure.lang.Numbers (min x y)) (. clojure.lang.Numbers (max x y))])
  ([x y & more]
   [(reduce min-max (min-max x y) more) (reduce min-max (min-max x y) more)]))

(defn status [field status game-users]
  (->> game-users
    (filter status)
    field
    (apply min-max)))

(status :current-points :active game-users)

; Testing
(min-max [1 2 3])  ; Well that did not work at all and actually was not needed either

; Importing a Dataset from a CSV File
; Ex 4.10: Importing Data from a CSV File
(require '[clojure.data.csv :as csv])
(require '[clojure.java.io :as io])
(with-open [r (io/reader "match_scores_1991-2016_unindexed_csv.csv")]
  (first (csv/read-csv r)))
(with-open [r (io/reader "match_scores_1991-2016_unindexed_csv.csv")]
  (count (csv/read-csv r)))

; Real-World Laziness
; Ex 4.11: Avoiding Lazy Evaluation Traps with Files
(with-open [r (io/reader "match_scores_1991-2016_unindexed_csv.csv")]
  (->> (csv/read-csv r)
    (map #(nth % 7))
    (take 6))) ; => Error: Stream closed
; Add doall
(with-open [r (io/reader "match_scores_1991-2016_unindexed_csv.csv")]
  (->> (csv/read-csv r)
    (map #(nth % 7))
    (take 6)
    doall))

; Ex 4.12: Parsing CSV with semantic-csv
; -> tennis.clj

 ; 5. Many to One: Reducing
(def weather-days
  [{:max 31
    :min 27
    :description :sunny
    :date "2019-09-24"}
   {:max 28
    :min 25
    :description :cloudy
    :date "2019-09-25"}
   {:max 22
    :min 18
    :description :rainy
    :date "2019-09-26"}
   {:max 35
    :min 16
    :description :stormy
    :date "2019-09-27"}
   {:max 35
    :min 19
    :description :sunny
    :date "2019-09-28"}])

(apply max (map :max weather-days))
(reduce (fn [max-day-so-far this-day]
          (if (> (:max this-day) (:max max-day-so-far))
            this-day
            max-day-so-far))
  weather-days)


; 11. Macros
(defmacro minimal-macro []
  '(println "I'm your macro overlord!"))
(minimal-macro)
(defn minimal-function []
  (println "I'm trapped inside a function!"))
(minimal-function)

(macroexpand '(minimal-function))
(macroexpand '(minimal-macro))

(defmacro mistaken-macro []
  (println "I'm your mistaken macro overlord!"))

(repeat 3 '(println "Macroni"))

(cons 'do (repeat 3 '(println "Macro")))

(defmacro multi-minimal [n-times]
  (cons 'do (repeat 3 '(println "Macro"))))

(multi-minimal 4)

(macroexpand '(multi-minimal 4))

(defmacro parameterized-multi-macro [n-times s]
  (concat (list 'let ['string-to-print s])
    (repeat n-times '(println string-to-print))))

(parameterized-multi-macro 3 "My string")

(defmacro parameterized-with-syntax [n-times s]
  `(do ~@(repeat n-times `(println ~s))))

(parameterized-with-syntax 3 "A string")

(macroexpand '(parameterized-with-syntax 3 "A string"))

; Exercise 11.01: The and-ors Macro

(partition-by (partial = '|) [1 2 '| 3 4])

(remove #(= '(|) %) '((1 2) (|) (3 4)))
(remove (partial = '(|)) '((1 2) (|) (3 4)))

(defmacro and-ors [& or-exprs]
  (let [groups (remove (partial = '(|)) (partition-by (partial = '|) or-exprs))]
    `(and

       ~@(map (fn [g] `(or ~@g)) groups))))

(and-ors (> 5 3) (= 6 6) | (> 6 3) | (= 5 5 5))

(and-ors
  (and-ors (= 3 3) | (= 5 5) (= 6 8))
  |
  (> 5 3) (= 6 6)
  |
  (> 6 3)
  |
  (= 5 5 5))

(macroexpand-1 '(and-ors (> 5 3) (= 6 6) | (> 6 3) | (= 5 5 5)))

; Exercise 11.02: An Automatic HTML Library

(defn tag-fn [tag]
  (fn [& content] (str tag content tag)))

(defmacro define-html-tags [& tags]
  `(do
     ~@(map (fn [tagname]
              `(def ~(symbol tagname) (tag-fn ~tagname)))
         tags)))

(define-html-tags "h1" "h2")

(h1 "hi" "ho")

; Ex 11.04 Monitoring functions

; iteration 1
(defmacro defmonitored
  [fn-name tx-fn & args-and-body]
  (let [
        ; TODO compile time bindings
        ]
    `(defn ~fn-name ~[]
       ; TODO
       )))

; Testing
(defmonitored my-func identity [])
(my-func)

; iteration 2

(defmacro defmonitored
  [fn-name tx-fn & args-and-body]
  (let [pre-arg-list (take-while (complement sequential?) args-and-body)
        fn-content (drop-while (complement sequential?) args-and-body)
        fn-bodies (if (vector? (first fn-content))
                    `(~fn-content)
                    fn-content)]
    `(defn ~fn-name ~@pre-arg-list
       ; TODO
       )))

; iteration 3

(defn wrap-fn-body
  [fn-name tx-fn b]
  (let [arg-list (first b)
        fn-body (rest b)]
    (when-not (first (filter #(= 'client-id %) arg-list))
      (throw (ex-info "Missing client-id argument" {})))
    `(~arg-list
       (let [start-time# (System/nanoTime)]
         (try
           (let [result# (do ~@fn-body)]
             (~tx-fn {:name ~(name fn-name)
                      :client-id ~'client-id
                      :status :complete
                      :start-time start-time#
                      :end-time (System/nanoTime)})
             result#)
           (catch Exception e#
             (~tx-fn {:name ~(name fn-name)
                      :client-id ~'client-id
                      :status :error
                      :start-time start-time#
                      :end-time (System/nanoTime)})
             (throw e#)))))))

(defmacro defmonitored
  [fn-name tx-fn & args-and-body]
  (let [pre-arg-list (take-while (complement sequential?) args-and-body)
        fn-content (drop-while (complement sequential?) args-and-body)
        fn-bodies (if (vector? (first fn-content))
                    `(~fn-content)
                    fn-content)]
    `(defn ~fn-name ~@pre-arg-list
       ~@(map (partial wrap-fn-body fn-name tx-fn) fn-bodies))))

; Testing
(defmonitored my-func println [client-id m] (assoc m :client client-id))
(my-func 32 {:data 123})

(macroexpand '(def my-number# 5))
; => (def my-number# 5) ; Remember that # is only magic inside syntax quoting
(macroexpand `(def my-number# 5))
; => (def my-number__2011__auto__ 5)

; Gensyms do not nest!
(defmacro fn-context [v & symbol-fn-pairs]
  `(let [v# ~v]
     ~@(map (fn [[sym f]]
              `(defn ~sym [x#]
                 (f v# x#))) (partition 2 symbol-fn-pairs))))
(macroexpand-1 `(fn-context 5 adder + subtractor - multiplier *))

; The fix
(defmacro fn-context [v & symbol-fn-pairs]
  (let [common-val-gensym (gensym "common-val-")]
    `(let [~common-val-gensym ~v]
       ~@(map (fn [[sym f]]
                `(defn ~sym [x#]
                   (~f ~common-val-gensym x#))) (partition 2 symbol-fn-pairs)))))

