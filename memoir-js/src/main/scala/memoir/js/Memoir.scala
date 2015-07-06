package memoir.js

import memoir.js.routes.MemoirRoutes

import japgolly.scalajs.react.React
import org.scalajs.dom
import scala.scalajs.js

/**
 * The starting point for the Memoir application.
 */
object Memoir extends js.JSApp {
  def main(): Unit = {
    React.render(MemoirRoutes.router(), dom.document.body)
  }
}
