name := "scala-trello"

version := "1.0"

scalaVersion := "2.10.3"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= {
  val akkaVersion = "2.3.2"
  val sprayVersion = "1.3.1"
  Seq(
    "com.fasterxml.jackson.core" % "jackson-core" % "2.3.3",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2",
	"com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2",
	"org.scalaequals" %% "scalaequals-core" % "1.2.0",
    "io.spray" % "spray-client" % sprayVersion,
    //"io.spray" % "spray-testkit" % sprayVersion % "test",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    //"com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "org.specs2" %% "specs2" % "2.3.11" % "test"
  )
}
