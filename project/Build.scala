import sbt._
import sbt.Keys._


object ApplicationBuild extends Build {

  val appName = "keijiban"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "mysql" % "mysql-connector-java" % "5.1.28",
    "com.typesafe.slick" %% "slick" % "2.1.0",
    "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
    "com.typesafe.play" %% "play-slick" % "0.8.1",
    "org.slf4j" % "slf4j-nop" % "1.6.4"
  )

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    version := appVersion,
    scalaVersion := "2.11.4",
    libraryDependencies ++= appDependencies
  )

}