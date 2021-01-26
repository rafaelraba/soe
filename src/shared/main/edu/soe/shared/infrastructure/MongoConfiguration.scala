package edu.soe.shared.infrastructure

import com.mongodb.reactivestreams.client.MongoClients

class MongoConfiguration() {
  final val client =MongoClients.create("mongodb://localhost:27017")
  final val db = client.getDatabase("soe")

}
