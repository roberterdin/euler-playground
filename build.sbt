name := "Euler_Problems"

version := "1.0"

scalaVersion := "2.12.2"

//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.4")

resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.github.pathikrit" % "better-files_2.12" % "2.17.1"
libraryDependencies += "com.storm-enroute" % "scalameter_2.12" % "0.8.2"


mainClass in Compile := Some("eu.erdin.euler.Main")


parallelExecution in Test := false
