package dao.db

import dao.driver.DriverComponent
import slick.driver.H2Driver

trait H2DBConfigProvider extends DBComponent {
  self: DriverComponent =>

  val driver = H2Driver

  import driver.api._

  val SCHEMA = getClass.getResource("/schema.sql").getPath

  // JDBC URL Connectivity
  val H2_URL = s"jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_UPPER=false;INIT=" +
    s"runscript from '$SCHEMA'"

  val db = Database.forURL(H2_URL, driver="org.h2.Driver")

}
