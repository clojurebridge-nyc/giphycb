(ns giphycb.cljs.core
  (:require [reagent.core :as r]
            [giphycb.cljs.app :refer [app]]))

(defn mount-root []
  (r/render [app] (.getElementById js/document "reagent-app")))

(defn ^:export main []
  (mount-root))
