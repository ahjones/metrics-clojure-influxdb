(ns metrics.reporters.influxdb
  "InfluxDB reporter"
  (:require [metrics.core :refer [default-registry]]
            [metrics.reporters :as mrep])
  (:import java.util.concurrent.TimeUnit
           java.net.InetSocketAddress
           [com.codahale.metrics Metric MetricRegistry MetricFilter]
           [com.izettle.metrics.influxdb InfluxDbReporter]
           [com.izettle.metrics.dw InfluxDbReporterFactory]))

(defn ^InfluxDbReporter reporter
  ([opts]
   (reporter default-registry opts))
  ([^MetricRegistry reg {:keys [host hostname port duration-unit filter db-name] :as opts
                         :or {port 8086
                              db-name "metrics"}}]
   (let [b (InfluxDbReporterFactory.)]
     (.setHost b (or host hostname "localhost"))
     (.setPort b port)
     (.setDatabase b db-name)
     (when-let [^TimeUnit du duration-unit]
       (.setPrecision b du))
     (.build b reg))))

(defn start
  "Report all metrics to influxdb periodically."
  [^InfluxDbReporter r ^long seconds]
  (mrep/start r seconds))

(defn stop
  "Stops reporting."
  [^InfluxDbReporter r]
  (mrep/stop r))
