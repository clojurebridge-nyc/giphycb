(ns giphycb.05-render-gifs.core
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def giphy-api-key "dc6zaTOxFJmzC")

(defn get-api [term]
  (let [search-url "http://api.giphy.com/v1/gifs/search"
        query-params {:q term :limit 10 :api_key giphy-api-key}
        response     (:body (client/get search-url {:query-params query-params}))
        data         (:data (json/parse-string response true))]
    data))
