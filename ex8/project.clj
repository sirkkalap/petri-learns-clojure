(defproject ex8 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [clojure.java-time "1.1.0"]]
  :repl-options {:init-ns ex8.core}
  ; Exe 8.13: Adding Leiningen Profiles to a Project
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[expectations "2.1.10"]]}})

; Testing
; lein show-profiles
; lein with-profile dev test

; Ex 8.14: Using User-Wide Profiles
; -> ~/.lein/profiles.clj
; {:user {:dependencies [[clojure-humanize "0.2.2"]]}}
; REPL
; (clojure.contrib.humanize/numberword 4589)
; (clojure.contrib.humanize/duration 500)