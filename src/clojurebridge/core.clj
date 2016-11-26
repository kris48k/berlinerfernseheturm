(ns clojurebridge.core
  (:require [quil.core :refer :all]))

; global variables
(def xGray (atom 210))
(def xBlack (atom 0))

(defn setup []
  (frame-rate 20)
  (smooth))
  

(defn drawBackground 
  "Drawing the Background" []
  (background @xGray @xGray @xGray))

(defn drawFernsehturm 
  "Drawing the Fernsehturm" []
  (fill @xBlack @xBlack @xBlack)
  (stroke-weight 0)
  (ellipse 250 300 150 150)
  (rect 240 177 20 50)
  (triangle 248 177 254 177 250 27)
  (quad 245 375 235 500 265 500 255 375))
  
(defn draw []
  (reset! xGray (quot (mouse-x) 2))
  (reset! xBlack (- 255 @xGray))
  (drawBackground)
  (drawFernsehturm))


; the entry point
(defsketch example
  :title "Example"
  :setup setup
  :draw draw
  :size [500 500])

