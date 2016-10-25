package com.mtrakr.dao.component

import java.sql.Timestamp

import com.mtrakr.dao.driver.DriverComponent
import com.mtrakr.models.{Users, UsersDetails}

trait UsersComponent { self: DriverComponent =>
  import driver.api._

  class UsersTable(tag: Tag) extends Table[Users](tag, "users") {

    def id = column[Long]("id", O.AutoInc, O.PrimaryKey)

    def name = column[Option[String]]("name")

    def email = column[String]("email")

    def createdTime = column[Timestamp]("created_ts")

    def lastUpdatedTime = column[Option[Timestamp]]("last_updated_time")

    def enabled = column[Boolean]("enabled")

    def phoneNum = column[Option[Long]]("phone_num")

    def dob = column[Option[Timestamp]]("dob")

    def usersDetails = (name, email, createdTime, lastUpdatedTime,
      enabled, phoneNum, dob) <>((UsersDetails.apply _).tupled, UsersDetails.unapply)

    def * = (id, usersDetails) <>((Users.apply _).tupled, Users.unapply)
  }
}
