package edu.soe.uds.student.infrastructure.repository


import edu.soe.uds.student.domian.{Student, StudentRepository}
import org.mongodb.scala.{Completed, MongoClient, MongoCollection, MongoDatabase, Observable, Observer}
import org.mongodb.scala.bson.collection.immutable.Document

class MongoStudentRepository extends StudentRepository {

  val client: MongoClient = MongoClient()
  val database: MongoDatabase = client.getDatabase("soe")
  val collection: MongoCollection[Document] = database.getCollection("students")

  override def save(student: Student): Unit = {
    val document: Document = Document("id" -> student.id.value, "name" -> student.name.value)
    val $insert: Observable[Completed] = collection.insertOne(document)

    $insert.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })
  }
}
