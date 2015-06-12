package memoir.js

import scala.scalajs.js
import scalajs.js.annotation.JSName
import scalajs.js.GlobalScope

/**
 * The `google` package provides the Scala bindings for Google's javascript client.
 *
 * @example import the apis from this package:
 * {{{
 *   import memoir.js.google.gapi
 * }}}
 */
package object google extends GlobalScope {
  /**
   * Root binding for the `gapi` object
   */
  val gapi: gapi = js.native
}

/**
 * Scala binding for Google's `gapi` javascript client
 */
sealed trait gapi extends js.Object {

  /**
   * Binding for Google's `auth` object.
   */
  val auth: auth = js.native
}

/**
 * Scala binding for Google's `auth` javascript client
 */
sealed trait auth extends js.Object {
  import memoir.js.messages.gapi.auth._

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
