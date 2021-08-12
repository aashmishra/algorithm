
name := "algorithm"

version := "0.1"

scalaVersion := "2.11.8"


val sparkVersion = "2.2.0"

scalaModuleInfo := scalaModuleInfo.value.map {
  _.withOverrideScalaVersion(true)
}

val excludeAllDep = List(
  ExclusionRule("com.sun.jdmk", "jmxtools"),
  ExclusionRule("com.sun.jmx", "jmxri"),
  ExclusionRule("javax.jms", "jms")
)
// Typesafe Config Library
libraryDependencies += "com.typesafe" % "config" % "1.2.1"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" excludeAll(excludeAllDep: _*),
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" excludeAll(excludeAllDep: _*),
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided" excludeAll(excludeAllDep: _*),
  "com.twitter" %% "util-collection" % "18.8.0",
  "org.scalaz" %% "scalaz-core" % "7.2.22",
  "org.scalaz" %% "scalaz-effect" % "7.2.22",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.22",
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "joda-time" % "joda-time" % "2.10.4",
"io.spray" %% "spray-json" % "1.3.5"
//  "com.dunnhumby" %% "core" % "1.30" excludeAll(excludeAllDep: _*)
)


// Test Setting
parallelExecution in Test := false

// Test Setting
fork in Test := false

// Assembly Setting
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
