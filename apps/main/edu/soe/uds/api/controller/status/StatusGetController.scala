package edu.soe.uds.api.controller.status

import akka.http.scaladsl.model.{HttpEntity, ContentTypes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute

object StatusGetController {
  def apply(): StandardRoute = complete(HttpEntity(ContentTypes.`application/json`, """{"status": "ok"}"""))
}
