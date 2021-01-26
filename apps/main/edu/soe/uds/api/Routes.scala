package edu.soe.uds.api

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import edu.soe.uds.api.controller.status.StatusGetController
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.json.JsValue


final  class Routes(container: EntryPointDependencyContainer) {
  val all: Route = get {
    path("status") (StatusGetController())
  } ~
    put {
      path("student") {
        jsonBody { body =>
          container.studentController.put(
            body("id").convertTo[String],
            body("name").convertTo[String]
          )
        }
      }
    }

  private def jsonBody(handler: Map[String, JsValue] => Route): Route =
    entity(as[JsValue])(json => handler(json.asJsObject.fields))

}

