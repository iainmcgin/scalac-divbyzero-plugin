name := "scalac-divbyzero-plugin"

version := "1.0"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

scalaVersion := "2.9.1-1"

crossScalaVersions := Seq("2.9.1", "2.10.0-SNAPSHOT")

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
