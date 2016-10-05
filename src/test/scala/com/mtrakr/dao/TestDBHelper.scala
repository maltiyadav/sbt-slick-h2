package com.mtrakr.dao

import com.mtrakr.dao.db.DBComponent
import com.mtrakr.dao.driver.DriverComponent
import slick.driver.H2Driver

trait TestDBHelper extends DBComponent {
  self: DriverComponent =>

  val driver = H2Driver

  import driver.api._

  val SCHEMA = getClass.getResource("/schema.sql").getPath
  val SCHEMA_DATA = getClass.getResource("/schema_data.sql").getPath

  val H2_URL = s"jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_UPPER=false;INIT=" +
    s"runscript from '$SCHEMA'\\;" +
    s"runscript from '$SCHEMA_DATA'"

  val db = Database.forURL(url = H2_URL, driver = "org.h2.Driver")

}
