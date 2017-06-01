(ns giphycb.web
  (:require [giphycb.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [hiccup.page :as page]
            [hiccup.form :as form]))

(defn layout
  [title & content]
  (page/html5
   [:head
    [:title title]
    (page/include-css "//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css")
    (page/include-css "//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css")
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]]
   [:body
    [:nav.navbar.navbar-default {:role "navigation"}
     [:div.container-fluid
      [:div.navbar-header
       [:a.navbar-brand {:href "/"} "ClojureBridge Giphy Fun"]]]]
    [:div.container
     content]]))

(defn search-results [search-term]
  (let [results (api/get-api search-term)]
    (layout "Giphy Fun Search Results"
            [:div#reagent-app]
            (page/include-js "/js/app.js")
            [:script
             {:type "text/javascript"}
             (format "window.searchResults = %s" results)]
            [:script
             {:type "text/javascript"}
             "giphycb.cljs.core.main();"])))

(defn main-page []
  (layout "Giphy Fun Search Form"
          [:h1 "Search Giphy!"]
          (form/form-to {:role "form"} [:get "/results"]
                        [:div.row
                         [:div.form-group.col-md-5
                          (form/label "search-term" "Giphy Search: ")
                          (form/text-field "search-term")
                          (form/submit-button "Submit")]])))

(defroutes main-routes
  (route/resources "/")
  (GET "/" [] (main-page))
  (GET "/results" [search-term] (search-results search-term)))

(def handler (site main-routes))
