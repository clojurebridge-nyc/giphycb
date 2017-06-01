(defproject giphycb "0.1.0-SNAPSHOT"
  :description "Demonstrates the use of the World Bank API"
  :url "https://github.com/clojurebridge/global-growth"
  :license {:name "Creative Commons Attribution License"
            :url "http://creativecommons.org/licenses/by/3.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]
                 [clj-http "3.6.0"]
                 [cheshire "5.7.1"]
                 [ring "1.6.1"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [reagent "0.6.2" :exclusions [org.clojure/clojure org.clojure/clojurescript]]]
  :plugins [[lein-ring "0.8.10"]
            [lein-cljsbuild "1.1.6"]
            [lein-ancient "0.6.10" :exclusions
             [cheshire org.apache.httpcomponents/httpclient]]]
  :ring {:handler giphycb.web/handler}
  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler {:main giphycb.cljs.core
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :asset-path "js/out"
                                   :optimizations :none
                                   :verbose true
                                   :pretty-print true}}]}
  :clean-targets ^{:protect false} ["resources/public/js" "target"]
  :main ^:skip-aot giphycb.core
  :target-path "target/%s")
