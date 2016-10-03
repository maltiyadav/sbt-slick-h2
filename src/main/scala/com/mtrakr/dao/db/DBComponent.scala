package com.mtrakr.dao.db

import com.mtrakr.dao.driver.DriverComponent

trait DBComponent extends DriverComponent{

  import driver.api._

  val db: Database

}