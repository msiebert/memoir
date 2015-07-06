package memoir.js.routes

import memoir.js.view.pages._
import memoir.js.view.Home

import japgolly.scalajs.react.extra.router2.{BaseUrl, Redirect, Router, RouterConfigDsl}

object MemoirRoutes {
  val config = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    (emptyRule
    | staticRoute(root, HomePage) ~> render(Home.component())
    ).notFound(redirectToPage(HomePage)(Redirect.Replace))
  }

  val router = Router(BaseUrl.fromWindowOrigin, config)
}
