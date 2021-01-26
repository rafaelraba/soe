package edu.soe.uds.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory
import edu.soe.uds.student.infrastructure.dependency_injection.StudentModuleDependencyContainer

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object UdsApiApp {
  def start(): Unit = {
    val appConfig    = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val container = new EntryPointDependencyContainer(new StudentModuleDependencyContainer())
    val routes          = new Routes(container)
    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host            = serverConfig.getString("http-server.host")
    val port            = serverConfig.getInt("http-server.port")

    implicit val system: ActorSystem                        = ActorSystem(actorSystemName)
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val bindingFuture = Http().newServerAt(host, port).bind(routes.all)
    println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
    StdIn.readLine()

    println("Stopping server...")

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => {
        system.terminate()
        println("Server stopped!")
      })
  }

}
