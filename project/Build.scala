import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "wordplaypress"
    val appVersion      = "0.1"

    val ssDependencies = Seq(
      // Add your project dependencies here,
      "com.typesafe" %% "play-plugins-util" % "2.0.1",
      "org.mindrot" % "jbcrypt" % "0.3m"
    )

    val appDependencies = Seq(
      "mysql" % "mysql-connector-java" % "5.1.18"
    )

    val secureSocial = PlayProject(
          "securesocial", appVersion, ssDependencies, mainLang = SCALA, path = file("modules/securesocial")
        ).settings(
          resolvers ++= Seq(
            "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
            "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
          )
    )


    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      resolvers += "play2auth repo" at "http://www.t2v.jp/maven-repo/",
      resolvers += "jbcrypt repo" at "http://mvnrepository.com/"
    ).dependsOn(secureSocial).aggregate(secureSocial)

}
