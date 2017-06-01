(ns giphycb.cljs.app
  (:require [reagent.core :as r]))

(defonce current-result-index (r/atom 0))

(defn giphy-gif-src [gif]
  (get-in gif [:images :downsized :url]))

(defn next-or-first [current-index results]
  (let [next-index  (inc current-index)
        size        (count results)]
    (if (>= next-index size)
      0
      next-index)))

(defn giphy-img [gif]
  [:img {:src (giphy-gif-src gif)}])

(defn focused-result [result]
  [giphy-img result])

(defn search-results [results]
  (let [curr-index @current-result-index]
    [:div
     [:h1 "Results!"]
     [focused-result (get results curr-index)]
     [:div
      (inc curr-index) " of " (count results)]
     [:button {:on-click #(swap! current-result-index next-or-first results)}
      "Next"]]))

(defn app []
  (let [results (js->clj (.-searchResults js/window) :keywordize-keys true)]
    [search-results (:data results)]))
