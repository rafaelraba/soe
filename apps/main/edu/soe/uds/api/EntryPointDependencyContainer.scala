package edu.soe.uds.api

import edu.soe.uds.api.controller.person.PersonPutController
import edu.soe.uds.person.infrastructure.dependency_injection.PersonModuleDependencyContainer

final class EntryPointDependencyContainer(personDependencies: PersonModuleDependencyContainer) {
  val personController = new PersonPutController()
}
