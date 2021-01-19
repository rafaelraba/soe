import sbt._

object Dependencies {
  object Versions {
    val akka     = "2.6.9"
    val akkaHttp = "10.2.1"
  }

  val shared = Seq(
    "com.typesafe.akka"      %% "akka-http"            % Versions.akkaHttp,
    "com.typesafe.akka"      %% "akka-actor"           % Versions.akka,
    "com.typesafe.akka"      %% "akka-stream"          % Versions.akka, // Explicit dependency due to: https://bit.ly/akka-http-25
    "com.typesafe.akka"      %% "akka-http-spray-json" % Versions.akkaHttp,
    "com.github.nscala-time" %% "nscala-time"          % "2.22.0",
    "com.lihaoyi"            %% "pprint"               % "0.5.6"
  )

  val test = Seq(
    "org.scalatest"     %% "scalatest"         % "3.1.1"           % Test,
    "org.scalamock"     %% "scalamock"         % "4.4.0"           % Test,
    "com.typesafe.akka" %% "akka-testkit"      % Versions.akka     % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp % Test
  )

  val uds = Seq()

}
