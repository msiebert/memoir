package goog.gapi.auth

import goog.gapi.auth.messages.{Authorize, AuthorizeResult}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Scala binding for Google's `gapi.auth` javascript client
 */
@JSName("gapi.auth")
object Auth extends js.Object {
  /**
   * Try to authorize through Google OAuth.
   *
   * @param message the message to pass to the api
   * @param callback the callback that will handle the result of the `authorize` call
   */
  def authorize(
      message: Authorize,
      callback: js.Function1[AuthorizeResult, Unit]
  ): Unit = js.native
}
