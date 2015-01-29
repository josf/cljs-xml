(defproject cljs-xml "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2725"]]

  :node-dependencies [[source-map-support "0.2.8"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]
            [cider/cider-nrepl "0.9.0-SNAPSHOT"]
            [com.cemerick/clojurescript.test "0.3.3"]]

  :source-paths ["src" "target/classes"]

  :clean-targets ["out/cljs_xml" "cljs_xml.js" "cljs_xml.min.js"]

  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src" "test"]
                        :compiler {:main cljs-xml.core
                                   :output-to "out/cljs_xml.js"
                                   :output-dir "out"
                                   :optimizations :whitespace
                                   :cache-analysis true
                                   :source-map "out/cljs_xml.js.map"}}
             {:id "release"
              :source-paths ["src"]
              :compiler {:main cljs-xml.core
                         :output-to "out-adv/cljs_xml.min.js"
                         :output-dir "out-adv"
                         :optimizations :advanced
                         :pretty-print false}}]
              :test-commands {"unit-tests" ["xvfb-run" "-a" "slimerjs" :runner
                                            "out/cljs_xml.js"]}}

  :profiles {:dev {:plugins [[com.cemerick/austin "0.1.6"]]}})
