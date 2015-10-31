(defproject groove-decoder "1.0.0"
  :description "Grooveshark offline file decoder"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.cli "0.3.3"]
                 [prismatic/hiphip "0.2.1"]
                 [me.raynes/fs "1.4.6"]]
  :main ^:skip-aot groove-decoder.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
