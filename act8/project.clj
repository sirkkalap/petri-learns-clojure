(defproject act8 "0.1.0-SNAPSHOT"
  :description "Format-Converting Application"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [cheshire "3.0.0"]]
  :main ^:skip-aot act8.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :qa {:dependencies [[expectations "2.1.10"]]
                  :plugins      [[lein-expectations "0.0.8"]]}
             :dev {}
             :prod {}})
