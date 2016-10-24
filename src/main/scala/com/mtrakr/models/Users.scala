package com.mtrakr.models

import java.sql.Timestamp


case class Users(
                  id: Long,
                  usersDetails: UsersDetails)

case class UsersDetails(
                         name: Option[String],
                         email: String,
                         createdTime: Timestamp,
                         lastUpdatedTime: Option[Timestamp],
                         enabled: Boolean,
                         phoneNum: Option[Long],
                         dob: Option[Timestamp]
                       )


