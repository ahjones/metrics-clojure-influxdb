(ns metrics.reporters.influx-test
  (:require [clojure.test :refer :all]
            [metrics.reporters.influxdb :refer :all]))


(deftest create-reporter
  (testing "simple construction"
    (is (reporter {})))

  (testing "construct with measurement mappings"
    (is (reporter {:measurement-mappings {"health" ".*\\health(\\.*)?"}})))

  (testing "construce with tags mappings"
    (is (reporter {:tags {"hostname" "host01"}}))))
