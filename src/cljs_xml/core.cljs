(ns cljs-xml.core
  (:require [clojure.browser.repl :as repl]
            [goog.dom :as gdom]
            [goog.dom.xml :as gxml]))

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(defn dom-from-xml-string [s]
  (gxml/loadXml s))


(defn child-nodes [el]
  (let [nodelist (.-childNodes el)
        nodecount (.-length nodelist)]
    (map #(.item nodelist %) (range nodecount))))

(declare parse-node)

(defn parse-element [el]
  (let [tagname (.-tagName el)]
    {:tag (keyword tagname)
     :content (mapv parse-node (child-nodes el))}))

(defn parse-text-node [t]
  (.-textContent t))


(defn parse-node [nd]
  (println (.-nodeType nd))
  (case (.-nodeType nd)
    1
    (parse-element nd)

    3
    (parse-text-node nd)

    true
    "blah"))
