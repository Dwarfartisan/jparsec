(defproject org.clojars.marsliu/jparsec-adv "0.5.0-SNAPSHOT"
  :description "Haskell Parsec Library's Java 1.8+ Editon"
  :url "https://github.com/Dwarfartisan/jparsec"
  :license {:name "THE MIT LICENSE"
            :url "https://opensource.org/licenses/MIT"}
  :profiles {:dev {:dependencies [[junit/junit "4.11"]]}}
  :plugins [[lein-junit "1.1.8"]]
  :java-source-paths ["src/java"]
  :junit ["src/test"])
