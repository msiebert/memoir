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
  lazy val jsProjects = Seq(scalaJsProject)

  lazy val playProject = Project("memoir-play", file("memoir-play"))
    .enablePlugins(PlayScala, PlayScalaJS).settings(
      scalaVersion := "2.11.6",

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
      scalaVersion := "2.11.6",
      persistLauncher := true,
      persistLauncher in Test := false,
      unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.8.0"
      )
    )
    .dependsOn(commonJs)

  lazy val commonProject = (crossProject.crossType(CrossType.Pure) in file("memoir-common"))
    .jsConfigure(_ enablePlugins ScalaJSPlay)
    .jsSettings(sourceMapsBase := baseDirectory.value / "..").settings(
      scalaVersion := "2.11.6"
    )

  lazy val commonJvm = commonProject.jvm
  lazy val commonJs = commonProject.js
}
