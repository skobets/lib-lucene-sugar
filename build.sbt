organization := "com.gilt"

name := "lib-lucene-sugar"

scalaVersion := "2.12.1"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "com.google.code.findbugs" % "jsr305" % "2.0.1",
  "com.google.guava" % "guava" % "20.0",
  "org.apache.lucene" % "lucene-core" % "6.5.0",
  "org.apache.lucene" % "lucene-analyzers-common" % "6.5.0",
  "org.apache.lucene" % "lucene-queryparser" % "6.5.0",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
