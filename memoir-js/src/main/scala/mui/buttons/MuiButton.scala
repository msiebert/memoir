package mui.buttons

import japgolly.scalajs.react.{ReactComponentB, ReactNode}
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * MuiButton styles
 */
object ButtonStyle extends Enumeration {
  val normal = Value("")
  val flat = Value("mui-btn-flat")
  val raised = Value("mui-btn-raised")
  val floating = Value("mui-btn-floating")
  val miniFloating = Value("mui-btn-floating mui-btn-floating-mini")
}

/**
 * MuiButton types
 */
object ButtonType extends Enumeration {
  val default = Value("mui-btn-default")
  val primary = Value("mui-btn-primary")
  val danger = Value("mui-btn-danger")
  val accent = Value("mui-btn-accent")
}

/**
 * MuiButton sizes
 */
object ButtonSize extends Enumeration {
  val normal = Value("")
  val large = Value("mui-btn-lg")
}

object MuiButton {
  case class Props(
    style: ButtonStyle.Value = ButtonStyle.normal,
    buttonType: ButtonType.Value = ButtonType.default,
    size: ButtonSize.Value = ButtonSize.normal,
    onClick: () => Unit
  )

  val component = ReactComponentB[Props]("MuiButton")
    .render { (props, children) =>
      <.button(^.className := s"mui-btn ${props.buttonType} ${props.style} ${props.size}")(children)
    }
    .build

  def apply(props: Props)(children: ReactNode*) = component(props, children)
  def apply() = component
}
