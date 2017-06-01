(ns giphycb.cljs.app
  (:require [reagent.core :as r]))

(defn giphy-gif-src [gif]
  (get-in gif [:images :downsized :url]))

(defn giphy-img [gif]
  [:img {:src (giphy-gif-src gif)}])

(defn search-results [results]
  [:div
   [:h1 "Results!"]
   [:ul
    (for [result results]
      [:li {:key (:slug result)}
       [giphy-img result]])]])

(defn app []
  (let [results (js->clj (.-searchResults js/window) :keywordize-keys true)]
    [search-results (:data results)]))
