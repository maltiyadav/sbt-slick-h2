package com.mtrakr.dao.db

import com.typesafe.config.ConfigFactory
import com.mtrakr.dao.driver.PGDriver

trait PostgresDBConfigProvider extends DBComponent{
  this: PGDriver =>

  import driver.api._

  private val config = ConfigFactory.load("application")
  val db = Database.forConfig("dev.postgresDbConf", config)

}