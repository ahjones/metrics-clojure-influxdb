# metrics-clojure-influxdb

[![build status](https://travis-ci.org/ahjones/metrics-clojure-influxdb.svg?branch=master)](https://travis-ci.org/ahjones/metrics-clojure-influxdb)

A Clojure library that wraps a Java Influx DB library and makes a
reporter available for use with
[Metrics Clojure](https://github.com/sjl/metrics-clojure)

## Usage

```Clojure
(require '[metrics.reporters.influxdb :as reporters.influxdb])

(let [r (reporters.influxdb/reporter {:host "localhost" :tags {"service" "demo"}})]
    (reporters.influxdb/start r 300))
```

## License

Copyright © 2016 Andrew Jones

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
