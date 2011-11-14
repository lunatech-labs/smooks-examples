name := "smooks-parse-custom-edi"

version :=  "0.1-alpha"

libraryDependencies ++= Seq(
                    "org.milyn" % "milyn-smooks-edi" % "1.5",
                    "org.milyn" % "milyn-smooks-templating" % "1.5",
                    "org.milyn.edi.unedifact" % "d01a-mapping" % "1.5-SNAPSHOT"                
)

resolvers ++= Seq(
          "Smooks staging repository" at "https://nexus.codehaus.org/content/repositories/orgmilyn-009",
          "Smooks EDIFACT mappings" at "https://nexus.codehaus.org/content/repositories/snapshots/"
)