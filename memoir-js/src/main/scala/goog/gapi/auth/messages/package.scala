package goog.gapi.auth

import scala.scalajs.js

/**
 * Messages that will be passed to Google's `gapi.auth` api.
 */
package object messages {
  /**
   * An interface the represents the message that is passed to the `gapi.auth.authorize`
   * call.
   */
  trait Authorize extends js.Object {
    val client_id: String = js.native
    val scope: String = js.native
    val immediate: Boolean = js.native
  }

  /**
   * The companion object to Authorize allows a Javascript object to be created with the values
   * expected by `gapi.auth.authorize`, but tries to maintain type safety for the rest of the
   * Scala codebase.
   */
  object Authorize {
    /**
     * Create an instance of the Authorize message.
     * @param clientId the client id provided by google
     * @param scope the scope we're requesting permission for
     * @param immediate whether to immediately refresh the token, with no ui shown to the user
     * @return the corresponding Authorize object
     */
    def apply(clientId: String, scope: String, immediate: Boolean): Authorize = {
      js.Dynamic.literal(
        client_id = clientId,
        scope = scope,
        immediate = immediate
      ).asInstanceOf[Authorize]
    }
  }

  /**
   * A trait representing the result of a call to `gapi.auth.authorize`
   */
  trait AuthorizeResult extends js.Object {
    val error: js.UndefOr[Boolean] = js.native
  }
}
