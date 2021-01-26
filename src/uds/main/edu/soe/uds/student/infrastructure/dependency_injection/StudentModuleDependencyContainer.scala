package edu.soe.uds.student.infrastructure.dependency_injection

import edu.soe.uds.student.application.create.StudentCreator
import edu.soe.uds.student.domian.StudentRepository
import edu.soe.uds.student.infrastructure.repository.MongoStudentRepository

final class StudentModuleDependencyContainer {
  val repository: StudentRepository = new MongoStudentRepository
  val studentCreator: StudentCreator = new StudentCreator(repository)

}
