(ns groove-decoder.core
  (:require
    [clojure.string :as string]
    [clojure.java.io :refer :all]
    [groove-decoder.transcode :refer :all]
    [me.raynes.fs :as fs])
  (:gen-class :main true))

(defn- usage [msg]
  (->> [
        msg
        ""
        "Decode an offline Grooveshark track."
        ""
        "Usage: groove-decoder /filename/|/glob/"
        ""
        ]
       (string/join \newline)))

(defn- run [files]
  (doall
    (pmap
      (fn [input-filename]
        (let
          [output-filename (clojure.string/replace input-filename #"\.dat$" ".mp3")]
          (do
            (println (str "Decoding: " (fs/absolute input-filename)))
            (process input-filename output-filename)
            (println (str "Done. Saved file: " (fs/absolute output-filename))))
          output-filename))
      files)))

(defn -main [& args]
  (println (str "Num args: " (count args)))
  (if (or (empty? args) (< (count args) 1))
    (println (usage "ERROR! Missing arguments"))
    (do
      (run args)
      (shutdown-agents))))



