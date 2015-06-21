package memoir.js

import scala.scalajs.js
import org.scalajs.dom
import memoir.common.Message

object HelloWorld extends js.JSApp {
  def main(): Unit = {
    val m = Message("Hello from JS too!")
    dom.document.getElementById("js").textContent = m.content
  }
}
