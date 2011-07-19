name := "scalac-divbyzero-plugin"

version := "1.0"

resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"

scalaVersion := "2.9.0-1"

crossScalaVersions := Seq("2.8.0", "2.8.1", "2.9.0", "2.9.0-1", "2.10.0-SNAPSHOT")

// if only building against one version, say 2.9.0-1, this is sufficient:
// libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.9.0-1"
//
// however, if building against multiple versions:
libraryDependencies <<= (scalaVersion, libraryDependencies) { (sv, ld) =>
  ld :+ ("org.scala-lang" % "scala-compiler" % sv)
} 
