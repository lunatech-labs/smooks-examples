name := "parse-custom-edi"

version :=  "0.1-alpha"

libraryDependencies ++= Seq(
                    "org.milyn" % "milyn-smooks-edi" % "1.5",
                    "org.milyn" % "milyn-smooks-templating" % "1.5",
                    "org.milyn.edi.unedifact" % "d01a-mapping" % "1.5-SNAPSHOT",
                    "org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final",
                    "org.hibernate" % "hibernate-core" % "3.6.8.Final"                
)

resolvers ++= Seq(
          "JBoss repository" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"
)