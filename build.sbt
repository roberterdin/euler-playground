name := "Euler_Problems"

version := "1.0"

scalaVersion := "2.11.8"


resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.7"
libraryDependencies += "com.github.pathikrit" %% "better-files" % "2.16.0"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

logBuffered := false

parallelExecution in Test := false
