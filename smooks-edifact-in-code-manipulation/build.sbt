name := "Smooks EDIFACT in code manipulation"

version := "0.1-alpha"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
                   "org.milyn" % "milyn-smooks-edi" % "1.5",
                   "org.milyn.edi.unedifact" % "d93a-binding" % "1.5-SNAPSHOT"
)

resolvers ++= Seq("Smooks staging repository" at "https://nexus.codehaus.org/content/repositories/orgmilyn-009/",
          "Smooks snapshots repository" at "https://nexus.codehaus.org/content/repositories/snapshots/"
)