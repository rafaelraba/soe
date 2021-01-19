disablePlugins(AssemblyPlugin)
scalaSource in Compile := baseDirectory.value / "main/"
scalaSource in Test := baseDirectory.value / "test/"
resourceDirectory in Compile := baseDirectory.value / "conf"

Setting.commonSettings

libraryDependencies ++= Dependencies.uds
test in assembly := {}
