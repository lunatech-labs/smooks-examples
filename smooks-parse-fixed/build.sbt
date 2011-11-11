name := "smooks-parse-fixed"

version := "0.1-alpha"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
                    "org.milyn" % "milyn-smooks-core" % "1.5",
                    "org.milyn" % "milyn-smooks-fixed-length" % "1.5",
                    "org.milyn" % "milyn-smooks-templating" % "1.5"
)

resolvers += "Smooks staging repository" at "https://nexus.codehaus.org/content/repositories/orgmilyn-009/"