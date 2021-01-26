package edu.soe.uds.student.domian

trait StudentRepository {
  def save(student: Student): Unit
}
