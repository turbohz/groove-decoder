(ns groove-decoder.transcode
  (:require
    [hiphip.double :as dbl]))

(defn inplace-xor-hh [^bytes a ^bytes out]
  (hiphip.array/afill! Byte/TYPE [_ out x a] (bit-xor (long x) 37))
  out)

(defn convert [^bytes bs]
  (let [out (make-array Byte/TYPE 1024)]
    (inplace-xor-hh bs out)))

(defn transcode [in out]
  (let [
        buffer (make-array Byte/TYPE 1024)
        length (.read in buffer)
        ]
    (if (>= length 0)
      ; when read does not return -1
      (do
        ;(display/set-progress progress)
        (.write out (convert buffer) 0 length)
        (recur in out))
      ; otherwise, we're done
      (.flush out))))

(defn process [input-filename output-filename]
  (with-open [
              in (java.io.BufferedInputStream. (java.io.FileInputStream. input-filename))
              out (java.io.BufferedOutputStream. (java.io.FileOutputStream. output-filename))]
    (transcode in out)))
