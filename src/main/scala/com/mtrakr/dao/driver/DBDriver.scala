package com.mtrakr.dao.driver

import slick.driver.{H2Driver, JdbcProfile, PostgresDriver}

trait PGDriver{ this: DriverComponent =>

  val driver: JdbcProfile = PostgresDriver

}

trait H2Driver { this: DriverComponent =>

  val driver: JdbcProfile = H2Driver

}