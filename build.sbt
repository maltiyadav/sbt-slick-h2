name := "classifyIncome"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.11" % "3.1.1.2",
  "com.typesafe.slick" % "slick-hikaricp_2.11" % "3.1.1.2",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "com.google.inject" % "guice" % "4.1.0"
)
