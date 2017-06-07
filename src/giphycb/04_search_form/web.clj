(ns giphycb.04-search-form.web
  (:require [giphycb.04-search-form.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
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

(defn rand-hello []
  (rand-nth ["Hello world!" "你好 世界!", "Bonjour le monde!", "Ciao mondo!"
             "안녕 세상!" "سلام دنیا" "Hola honua!" "Hei verden!" "Hallo welt!"]))

(defn search-results [search-term]
  (layout "Giphy Fun Search Results"
          [:h1 "Results!"]
           [:div {:style "width: 800px; word-wrap: break-word;"}
            (str (api/get-api search-term))]))

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

(def handler
  (wrap-defaults main-routes site-defaults))
