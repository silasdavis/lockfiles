(defproject lockfiles "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.forward/yaml "1.0.6"]]
  :main ^:skip-aot lockfiles.core
  :bin {:name "lockmerge"
        :bin-path "~/.local/bin"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
