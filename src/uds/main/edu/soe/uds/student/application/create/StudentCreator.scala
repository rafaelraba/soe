package edu.soe.uds.student.application.create

import edu.soe.uds.student.domian.{Student, StudentRepository}

import java.util.Date

final class StudentCreator(repository: StudentRepository) {

  def create(id: String,
             name: String,
             birthDate: Date,
             email: String,
             gender: String,
             code: String,
             documentNumber: String,
             documentType: String): Unit = {
    val student: Student = Student(id, name, birthDate, gender, email, documentNumber, documentType, code)
    repository.save(student)

  }
}
