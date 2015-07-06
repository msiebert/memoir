package memoir.js.view

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import mui.buttons.{ButtonStyle, ButtonType, MuiButton}

/**
 * Object that contains the react component to render the homepage.
 */
object Home {
  val component = ReactComponentB[Unit]("Home Page")
    .render( _ =>
      <.div(^.className := "mui-container")(
        <.div(^.className := "home")(
          <.h1(^.className := "title display-font")("Memoir"),
          <.h3(^.className := "description display-font")("Journal in the Cloud"),
          MuiButton(MuiButton.Props(
            style = ButtonStyle.raised,
            buttonType = ButtonType.primary,
            onClick = { () => println("herro worrd") }
          ))("Login With Google")
        )
      )
    ).buildU
}
