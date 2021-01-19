package edu.soe

import edu.soe.uds.api.UdsApiApp

object Launcher {
  private val UdsApiArgument = "uds-api"

  def main (args: Array[String]): Unit = {
    if(args.length != 1) {
      throw new RuntimeException("You need specify with app to start")
    }

    args(0) match {
      case UdsApiArgument => UdsApiApp.start()
    }

  }


}
