package edu.soe.shared.domain

class Person(private val id: PersonId,
             private val name: PersonName,
             private val birthDate: PersonBirthDate,
             private val gender: PersonGender,
             private val email: PersonEmail,
             private val documentNumber: PersonDocumentNumber,
             private val documentType: PersonDocumentType) {}
