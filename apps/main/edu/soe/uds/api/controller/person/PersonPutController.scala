package edu.soe.uds.api.controller.person

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute

class PersonPutController {
  def put(): StandardRoute = complete(HttpEntity(ContentTypes.`application/json`, """{"status": "ok"}"""))

}
