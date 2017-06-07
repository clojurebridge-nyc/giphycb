(ns giphycb.03-call-api.core
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def giphy-api-key "dc6zaTOxFJmzC")

(defn get-api [term]
  (let [search-url "http://api.giphy.com/v1/gifs/search"
        query-params {:q term :limit 10 :api_key giphy-api-key}
        response     (client/get search-url {:query-params query-params})
        results      (:body response)]
    results))
