name := "low-level"

version :=  "0.1-alpha"

libraryDependencies ++= Seq(
                    "org.milyn" % "milyn-smooks-javabean" % "1.5",
                    "org.milyn.edi.unedifact" % "d01a-mapping" % "1.5-SNAPSHOT"                
)

resolvers ++= Seq(
          "Smooks staging repository" at "https://nexus.codehaus.org/content/repositories/orgmilyn-009",
          "Smooks EDIFACT mappings" at "https://nexus.codehaus.org/content/repositories/snapshots/"
)