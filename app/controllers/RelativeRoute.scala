package controllers

import play.api.mvc.{AnyContent, Request}

object RelativeRoute {
  def versioned(asset: String)(implicit request: Request[AnyContent]): String = {
    val root = request.uri.split("/").indices.map(_ => "..").mkString("/")
    root + routes.Assets.versioned(asset).toString
  }
}
