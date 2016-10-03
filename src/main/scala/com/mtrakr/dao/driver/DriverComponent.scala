package com.mtrakr.dao.driver

import slick.driver.JdbcProfile

trait DriverComponent{

  implicit val global = scala.concurrent.ExecutionContext.Implicits.global

  val driver: JdbcProfile

}