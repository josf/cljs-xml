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

(defn get-attributes [attr-map]
  (let [attr-count (.-length attr-map)]
    (if (= 0 attr-count)
      {}
      (into {}
        (map
          (fn [idx]
            (let [attr (.item attr-map idx)]
              [(keyword (.-name attr)) (.-value attr)]))
          (range attr-count))))))

(defn parse-element [el]
  (let [tagname (.-tagName el)
        attributeMap (.-attributes el)]
    {:tag (keyword tagname)
     :content (mapv parse-node (child-nodes el))
     :attrs (get-attributes (.-attributes el))}))

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
