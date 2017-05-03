(ns lockfiles.core
  (:gen-class)
  (:require [yaml.core :as yaml]
            [yaml.reader :as yamlreader]
            [flatland.useful.map :as flatmap]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (for [ys (map yaml/parse-string (map slurp args))]
    (println ys)))