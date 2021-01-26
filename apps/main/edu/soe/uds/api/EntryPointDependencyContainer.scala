package edu.soe.uds.api

import edu.soe.uds.api.controller.student.StudentPutController
import edu.soe.uds.student.infrastructure.dependency_injection.StudentModuleDependencyContainer

final class EntryPointDependencyContainer(studentDependencies: StudentModuleDependencyContainer) {
  val studentController = new StudentPutController(studentDependencies.studentCreator)
}

