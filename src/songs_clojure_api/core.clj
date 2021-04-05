(ns songs-clojure-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))


; Simple body page
(defn simple-body-page [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Perros y gatos!"})

; Request example
(defn request-example [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (->>
          (pp/pprint req)
          (str "Request object: " req))})

; Request with parameters
(defn give-name [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (->
          (pp/pprint req)
          (str "Your name is " (:name (:params req))))})

; ROUTES
(defroutes app-routes
  (GET "/" [] simple-body-page)
  (GET "/name" [] give-name)
  (GET "/request" [] request-example)
  (route/not-found "Page not found!"))

; MAIN
(defn -main
  "Perros y gatos"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    ; Run server without ring defaults
    ; (server/run-server #'app-routes {:port port})
    (println (str "Running webserver at http://127.0.0.1:" port "/"))))

