(ns lockfiles.core
  (:gen-class)
  (:require [yaml.core :as yaml]
            [yaml.reader :as yamlreader]))

(defn -main
  "Merges Trash vendor.conf lockfiles together. Takes a list of paths to vendor.conf files as its arguments.
  Dependencies appearing in lockfiles appearing later in the argument list take precedence over those appearing earlier.
  Therefore provide lockfiles intended to override later than those containing the base dependencies."
  [& args]
  (if (> (count args) 0)
    (let [flattened (for [imports (map (comp :import yaml/parse-string) (map slurp args))
                          kvs (map (juxt :package identity) imports)] kvs)
          merged (into {} flattened)
          lockfile {:import (sort-by :package (vals merged))}
          yaml-string (yaml/generate-string lockfile :dumper-options {:flow-style :block})]
      (println yaml-string))
    (binding [*out* *err*]
      (println "Merge together Trash lockfiles.

Usage:
      lockmerge <paths>...

Where paths is list of paths to vendor.conf lockfiles to be merged together.
Those provided later override those provided later."))))