package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request =>
    import RelativeRoute.callToRelativeCall
    val foo: String = routes.HomeController.index()

    import RelativeRoute.callToBetterCall
    val bar = routes.HomeController.index().relative
    Ok(views.html.index())
  }

  def sub = Action { implicit request =>
    Ok(views.html.sub())
  }

}
