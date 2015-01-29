(ns cljs-xml.core-test
    (:require-macros [cemerick.cljs.test
                      :refer (is deftest with-test run-tests testing test-var)])
    (:require [cemerick.cljs.test]
              [cljs-xml.core :as xc]
              [cljs-xml.sample :as xs]))

(deftest build-dom
  "Build a DOM from string. Necessary for other tests to run."
  (let [dom (xc/dom-from-xml-string xs/tei)]
    (is (.-documentElement dom))))

(deftest child-nodes
  (let [dom (xc/dom-from-xml-string xs/tei)
        top-el (.-documentElement dom)
        chils (xc/child-nodes top-el)]
    (is (seq? chils))
    (is (pos? (count chils)))))
