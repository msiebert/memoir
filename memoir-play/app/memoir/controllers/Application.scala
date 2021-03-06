package memoir.controllers

import memoir.views.html.{index => indexHtml}
import play.api.mvc.{Action, Controller}

/**
 * This controller serves up the main application pages, such as the index page.
 */
object Application extends Controller {
  /**
   * Index page
   */
  def index = Action { request =>
    Ok(indexHtml())
  }
}
