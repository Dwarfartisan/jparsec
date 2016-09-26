(defproject org.clojars.marsliu/jparsec-adv "0.6.9"
  :name "JParsec"
  :description "Haskell Parsec Library's Java 1.8+ Editon"
  :url "https://github.com/Dwarfartisan/jparsec"
  :license {:name "THE MIT LICENSE"
            :url "https://opensource.org/licenses/MIT"}
  :profiles {:dev {:dependencies [[junit/junit "4.11"]]
                   :java-source-paths ["src/java" "test/java"]}}
  :plugins [[lein-junit "1.1.8"]]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"]
  ;; :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:unchecked" "-Xlint:varargs"]
  :junit ["test/java"])
