dependencyOverrides += "org.scala-sbt" % "sbt" % "0.13.7"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.3")

addSbtPlugin("com.vmunier" % "sbt-play-scalajs" % "0.2.4")

resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Resolver.typesafeRepo("releases")
)
