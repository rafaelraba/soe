package edu.soe.uds.student.domian

import edu.soe.shared.domain.{Person, PersonBirthDate, PersonDocumentNumber, PersonDocumentType, PersonEmail, PersonGender, PersonId, PersonName}

import java.util.Date

object Student {
  def apply(id: String,
            name: String,
            birthDate: Date,
            gender: String,
            email: String,
            documentNumber: String,
            documentType: String,
            code: String): Student =
    Student(
      PersonId(id),
      PersonName(name),
      PersonBirthDate(birthDate),
      PersonGender(gender),
      PersonEmail(email),
      PersonDocumentNumber(documentNumber),
      PersonDocumentType(documentType),
      StudentCode(code)
    )
}

case class Student(id: PersonId,
                   name: PersonName,
                   birthDate: PersonBirthDate,
                   gender: PersonGender,
                   email: PersonEmail,
                   documentNumber: PersonDocumentNumber,
                   documentType: PersonDocumentType,
                   code: StudentCode)
    extends Person(id, name, birthDate, gender, email, documentNumber, documentType) {}
