import SiteKeys._

organization := "com.livestream"

name := "scredis"

version := "2.0.9-snap"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-deprecation")

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2" excludeAll(
    ExclusionRule(organization = "org.slf4j")
    ),
  "com.typesafe" % "config" % "1.2.0",
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "com.storm-enroute" %% "scalameter" % "0.6" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-simple" % "1.7.25" % Test
)

parallelExecution in Test := false

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)

sources in (Compile,doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false
