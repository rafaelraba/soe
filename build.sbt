/** ********* PROJECT INFO ******************/
name := "soe"
version := "1.0"

disablePlugins(AssemblyPlugin)
lazy val root =(project in file(".")).aggregate(apps, uds, shared)

lazy val apps = Project(id = "apps", base = file("apps/"))
  .dependsOn(uds % "compile->compile;test->test")
  .dependsOn(shared % "compile->compile;test->test")

lazy val shared = Project(id = "shared", base = file("src/shared"))
lazy val uds    = Project(id = "uds", base = file("src/uds")).dependsOn(shared % "compile->compile;test->test")

Setting.commonSettings

/** ********* COMMANDS ALIASES ******************/
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("f", "scalafmt")             // Format production files according to ScalaFmt
addCommandAlias("fc", "scalafmtCheck")       // Check if production files are formatted according to ScalaFmt
addCommandAlias("tf", "test:scalafmt")       // Format test files according to ScalaFmt
addCommandAlias("tfc", "test:scalafmtCheck") // Check if test files are formatted according to ScalaFmt

// All the needed tasks before pushing to the repository (compile, compile test, format check in prod and test)
addCommandAlias("prep", ";c;tc;fc;tfc")

lazy val pack = taskKey[Unit]("Packages application as a fat jar")
pack := {
  (assembly in apps).toTask.value
}

test in assembly := {}
