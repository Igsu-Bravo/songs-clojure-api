(defproject songs-clojure-api "0.1.0-SNAPSHOT"
  :description "API for keeping track of uncompleted musical projects."
  :url "https://github.com/Igsu-Bravo/songs-clojure-api"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot songs-clojure-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
