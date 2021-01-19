package edu.soe.uds.api

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import edu.soe.uds.api.controller.status.StatusGetController

object Routes {
  val all: Route = get {
    path("status") (StatusGetController())
  }
}

