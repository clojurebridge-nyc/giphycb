(ns giphycb.01-init.web
  (:require [giphycb.01-init.core :as api]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn rand-hello []
  (rand-nth ["Hello world!" "你好 世界!", "Bonjour le monde!", "Ciao mondo!"
             "안녕 세상!" "سلام دنیا" "Hola honua!" "Hei verden!" "Hallo welt!"]))

(defn main-page []
  (rand-hello))

(defroutes main-routes
  (route/resources "/")
  (GET "/" [] (main-page)))

(def handler
  (wrap-defaults main-routes site-defaults))
