name := "scalac-divbyzero-plugin"

version := "1.0"

resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"

scalaVersion := "2.9.0-1"

crossScalaVersions := Seq("2.8.0", "2.8.1", "2.9.0", "2.9.0-1", "2.10.0-SNAPSHOT")

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
