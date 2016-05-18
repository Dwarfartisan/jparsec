(defproject org.clojars.marsliu/jparsec-normal "0.5.0-SNAPSHOT"
  :description "Haskell Parsec Library's Java 1.6 Editon"
  :url "https://github.com/Dwarfartisan/jparsec"
  :license {:name "THE MIT LICENSE"
            :url "https://opensource.org/licenses/MIT"}
;;  :dependencies [[junit "4.12"]]
  :profiles {:dev {:dependencies [[junit/junit "4.11"]]
                   :java-source-paths ["src/java" "src/test"]}}
  :plugins [[lein-junit "1.1.8"]]
  :java-source-paths ["src/java"]
  :junit ["src/test"])
