(ns lockfiles.core
  (:gen-class)
  (:require [yaml.core :as yaml]
            [yaml.reader :as yamlreader]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [flattened (for [imports (map (comp :import yaml/parse-string) (map slurp args))
                        kvs (map (juxt :package identity) imports)] kvs)
        merged (into {} flattened)
        lockfile {:import (sort-by :package (vals merged))}
        yaml-string (yaml/generate-string lockfile :dumper-options {:flow-style :block})]
    (println yaml-string)))