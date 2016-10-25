package com.mtrakr.dao.db

import com.mtrakr.dao.driver.DriverComponent
import com.typesafe.config.ConfigFactory
import slick.driver.PostgresDriver

trait PostgresDBConfigProvider extends DBComponent {
  self: DriverComponent =>

  val driver = PostgresDriver

  import driver.api._

  private val config = ConfigFactory.load("application")
  val db = Database.forConfig("dev.postgresDbConf", config)

}



