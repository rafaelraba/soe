import sbt.{Tests, _}
import Keys.{ exportJars, _}
import org.scalafmt.sbt.ScalafmtPlugin.autoImport._

object Setting {
  val commonSettings = Seq(
    organization := "edu.soe",
    scalaVersion := "2.13.3",
    scalacOptions := {
      val default = Seq(
        "-Xlint",
        "-Xfatal-warnings",
        "-unchecked",
        "-deprecation",
        "-feature",
        "-language:higherKinds"
      )
      if (version.value.endsWith("SNAPSHOT")) {
        default :+ "-Xcheckinit"
      } else { default } // check against early initialization
    },
    scalacOptions in (Test, console) --= Seq("-Ywarn-unused:imports", "-Xfatal-warnings"),
    scalacOptions in (Test, console) ++= Seq("-Ywarn-unused:-imports"),
    javaOptions += "-Duser.timezone=UTC",
    fork in Test := false,
    parallelExecution in Test := false,
    testOptions in Test ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
      Tests.Argument("-oDF")
    ),
    cancelable in Global := true,
    // Scalafmt
    scalafmtConfig := Some(file(".scalafmt.conf")),
    // OneJar
    exportJars := true
  )
}
