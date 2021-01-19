Setting.commonSettings
scalaSource in Compile := baseDirectory.value / "main/"
scalaSource in Test := baseDirectory.value / "test/"
resourceDirectory in Compile := baseDirectory.value / "conf"


libraryDependencies ++= Dependencies.shared
libraryDependencies ++= Dependencies.test

fork in run := true
connectInput in run := true

mainClass in assembly := Some("edu.soe.Launcher")
assemblyJarName in assembly := "soe.jar"
assemblyOutputPath in assembly := baseDirectory.value / ".." / "package" / (assemblyJarName in assembly).value
test in assembly := {}


