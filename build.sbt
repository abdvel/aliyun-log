name := "aliyun-log"

version := "2.0.1"

organization := "com.github.abdvel"
homepage := Some(url("https://github.com/abdvel/aliyun-log"))
scmInfo := Some(ScmInfo(url("https://github.com/abdvel/aliyun-log"), "git@github.com:abdvel/aliyun-log.git"))
developers := List(Developer("abdvel", "abdvel", "abdullahveliogluu@gmail.com", url("https://abdullahvelioglu.com")))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

scalaVersion := "2.13.2"
crossScalaVersions := Nil

libraryDependencies ++= Seq(
  "com.aliyun.openservices" % "aliyun-log" % "0.6.60"
)
