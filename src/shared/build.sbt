disablePlugins(AssemblyPlugin)
Setting.commonSettings
scalaSource in Compile := baseDirectory.value / "main/"
scalaSource in Test := baseDirectory.value / "test/"
resourceDirectory in Compile := baseDirectory.value / "conf"

libraryDependencies ++= Dependencies.shared

