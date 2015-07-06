package memoir

import com.typesafe.sbt.less.Import.LessKeys
import com.typesafe.sbt.web.SbtWeb.autoImport._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import play.Play.autoImport._
import play.PlayScala
import playscalajs.{PlayScalaJS, ScalaJSPlay}
import playscalajs.PlayScalaJS.autoImport._
import playscalajs.ScalaJSPlay.autoImport._
import sbt._
import sbt.Keys._
import sbt.Project.projectToRef

object PlayMemoir extends Build {
  object Versions {
    val scala = "2.11.6"
    val react = "0.12.1"
    val scalajsReact = "0.9.0"
  }

  lazy val jsProjects = Seq(scalaJsProject)

  lazy val playProject = Project("memoir-play", file("memoir-play"))
    .enablePlugins(PlayScala, PlayScalaJS).settings(
      scalaVersion := Versions.scala,

      // sbt-less settings
      includeFilter in (Assets, LessKeys.less) := "*.less",
      excludeFilter in (Assets, LessKeys.less) := "_*.less",

      // scala js settings
      scalaJSProjects := jsProjects,
      pipelineStages := Seq(scalaJSProd),

      libraryDependencies ++= Seq(
        "com.vmunier" %% "play-scalajs-scripts" % "0.1.0"
      )
    )
    .aggregate(jsProjects.map(projectToRef): _*)
    .dependsOn(commonJvm)


  lazy val scalaJsProject = Project("memoir-js", file("memoir-js"))
    .enablePlugins(ScalaJSPlugin, ScalaJSPlay).settings(
      scalaVersion := Versions.scala,
      persistLauncher := true,
      persistLauncher in Test := false,
      unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
      skip in packageJSDependencies := false,
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.8.0",
        "com.github.japgolly.scalajs-react" %%% "core" % Versions.scalajsReact,
        "com.github.japgolly.scalajs-react" %%% "extra" % Versions.scalajsReact
      ),
      jsDependencies ++= Seq(
        "org.webjars" % "react" % Versions.react / "react-with-addons.js" commonJSName "React"
      )
    ).dependsOn(commonJs)

  lazy val commonProject = (crossProject.crossType(CrossType.Pure) in file("memoir-common"))
    .jsConfigure(_ enablePlugins ScalaJSPlay)
    .jsSettings(sourceMapsBase := baseDirectory.value / "..").settings(
      scalaVersion := Versions.scala
    )

  lazy val commonJvm = commonProject.jvm
  lazy val commonJs = commonProject.js
}
