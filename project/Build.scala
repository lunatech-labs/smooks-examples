import sbt._
import Keys._

object SmooksExperiments extends Build {
       lazy val root = Project(id = "smooks-experiments",
                               base = file("."))
       lazy val smooksParseFixed = Project(id = "parse-fixed",
                                             base = file("parse-fixed")) dependsOn(root)
       lazy val edifactOutput = Project(id = "edifact-output",
                                             base = file("edifact-output")) dependsOn(root)
       lazy val lowLevel = Project(id = "low-level",
                                             base = file("low-level")) dependsOn(root)
       lazy val inCodeManipulation = Project(id ="edifact-in-code-manipulation",
                                             base = file("edifact-in-code-manipulation")) dependsOn(root)

      lazy val fromScratch = Project(id ="write-edi-from-scratch",
                                             base = file("write-edi-from-scratch")) dependsOn(root)

       lazy val parseCustomEdi = Project(id="parse-custom-edi",
                                         base = file("parse-custom-edi")) dependsOn(root)

       override lazy val settings = super.settings ++
       Seq(                          
       resolvers ++= Seq("Smooks staging repository" at "https://nexus.codehaus.org/content/repositories/orgmilyn-009/",
                  "Smooks UNEDIFACT mappings" at "https://nexus.codehaus.org/content/repositories/snapshots/"
),
        libraryDependencies += "org.milyn" % "milyn-smooks-core" % "1.5")
       
}
