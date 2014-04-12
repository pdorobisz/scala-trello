name := "scala-trello"

version := "1.0"

scalaVersion := "2.10.3"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= {
  val akkaV = "2.3.2"
  val sprayV = "1.3.1"
  Seq(
    "io.spray" % "spray-client" % sprayV,
    "io.spray" %% "spray-json" % "1.2.6",
    //"io.spray" % "spray-testkit" % sprayV % "test",
    "com.typesafe.akka" %% "akka-actor" % akkaV
    //"com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    //"org.specs2" %% "specs2" % "2.2.3" % "test"
  )
}
