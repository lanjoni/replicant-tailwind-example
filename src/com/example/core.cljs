(ns com.example.core
  (:require [com.example.views.app :as app]
            [replicant.dom :as r]))

(defn render [state]
  (-> js/document
      (.getElementById "app")
      (r/render (app/app state))))

(defn init [!state]
  (add-watch !state ::render (fn [_ _ _ state] (render state)))

  (r/set-dispatch!
   (fn [_ event-data]
     (doseq [[action & args] event-data]
       (case action
         ::app/inc-number (swap! !state update :number inc)))))

  (swap! !state assoc ::loaded-at (.getTime (js/Date.))))
