(ns com.example.dev
  (:require [com.example.core :as core]))

(def !state (atom {:number 0}))

(defn ^:dev/after-load reload []
  (prn "Reloading...")
  (core/init !state))

(defn ^:export main []
  (core/init !state))
