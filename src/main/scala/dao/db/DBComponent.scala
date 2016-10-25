package dao.db

import dao.driver.DriverComponent

trait DBComponent extends DriverComponent{

  import driver.api._

  val db: Database

}