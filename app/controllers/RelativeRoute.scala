package controllers

import play.api.mvc.{AnyContent, Call, Request}

object RelativeRoute {
  def at(route: String)(implicit request: Request[AnyContent]): String =
    rel + route

  def versioned(asset: String)(implicit request: Request[AnyContent]): String =
    rel + routes.Assets.versioned(asset).toString

  implicit def callToRelativeCall(call: Call)(implicit request: Request[AnyContent]): String =
    at(call.toString)

  implicit def callToBetterCall(call: Call)(implicit request: Request[AnyContent]): BetterCall =
    new BetterCall(call)

  private def rel(implicit request: Request[AnyContent]): String =
    request.uri.split("/").indices.map(_ => "..").mkString("/")

  class BetterCall(call: Call) extends Call(call.method, call.url) {
    def relative(implicit request: Request[AnyContent]): String =
      rel + url
  }
}

