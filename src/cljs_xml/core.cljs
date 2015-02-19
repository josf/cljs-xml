(ns cljs-xml.core
  (:require [clojure.browser.repl :as repl]
            [goog.dom :as gdom]
            [goog.dom.xml :as gxml]))

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

;;;  lifted directly from data.xml
(defrecord Element [tag attrs content])
(defrecord CData [content])
(defrecord Comment [content])

(defn element [tag & [attrs & content]]
  (Element. tag (or attrs {}) (remove nil? content)))

(defn cdata [content]
  (CData. content))

(defn xml-comment [content]
  (Comment. content))
;;; end lifted directly from data.xml


(defn dom-from-xml-string [s]
  (gxml/loadXml s))

(defn child-nodes [el]
  (let [nodelist (.-childNodes el)
        nodecount (.-length nodelist)]
    (map #(.item nodelist %) (range nodecount))))

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

(declare parse-node)
(defn parse-element [el]
  (let [tagname (.-tagName el)
        attributeMap (.-attributes el)]
    (element
      (keyword tagname)
      (get-attributes (.-attributes el))
      (mapv parse-node (child-nodes el)))))

(defn parse-text-node [t]
  (.-textContent t))

(defn parse-comment [c]
  (xml-comment (.-data c)))

(defn parse-node [nd]
  (case (.-nodeType nd)
    1
    (parse-element nd)

    3
    (parse-text-node nd)

    8                                   ; comments
    (parse-comment nd)
    
    true
    "blah"))
