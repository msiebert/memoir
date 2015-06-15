package memoir.js.oauth

import memoir.js.google.gapi
import memoir.js.messages.gapi.auth.{Authorize, AuthorizeResult}
import scala.scalajs.js.timers.setTimeout
import scalajs.js.annotation.JSExport


/**
 * The OAuth object will handle authenticating with OAuth for the Google Drive API.
 */
object OAuth {
  val clientId = ""
  val scopes = "https://www.googleapis.com/auth/drive"

  /**
   * This function is first called when the page is first loaded. Tries to get an auth token from
   * Google.
   */
  def checkAuth(): Unit = {
    gapi.auth.authorize(Authorize(clientId, scopes, true), { data: AuthorizeResult =>
      println(data.error)
    })
  }
}

/**
 * An object provided solely to bootstrap the oauth authorization process with `gapi.auth.authorize`
 */
@JSExport("OAuthBootstrap")
object OAuthBootstrap {
  setTimeout(1000) {
    OAuth.checkAuth()
  }
}
