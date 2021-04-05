(defproject songs-clojure-api "0.1.0-SNAPSHOT"
  :description "API for keeping track of uncompleted musical projects."
  :url "https://github.com/Igsu-Bravo/songs-clojure-api"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 ; Compojure - Routing
                 [compojure "1.6.1"]
                 ; HTTP lib for client/server
                 [http-kit "2.3.0"]
                 ; Ring defaults - query params
                 [ring/ring-defaults "0.3.2"]
                 ; Clojure data.JSON lib
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot songs-clojure-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
