package edu.soe.uds.api.controller.student

import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import edu.soe.uds.student.application.create.StudentCreator

import java.util.Date

class StudentPutController(creator: StudentCreator) {
  def put(id: String,
          name: String,
  ): StandardRoute = {
    creator.create(id, name, birthDate = new Date(), email = "", gender = "", code = "123", documentNumber ="123",  documentType="cc")
    complete(HttpResponse(NoContent))
  }

}
