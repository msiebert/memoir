package memoir.js.view

/**
 * Contains classes for use with the Router.
 */
package object pages {
  /**
   * Base class for all pages. All pages must extend `Page` so they can be used by the router.
   */
  sealed trait Page

  /**
   * Homepage
   */
  case object HomePage extends Page
}
