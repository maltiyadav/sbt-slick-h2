package com.mtrakr.dao

import com.google.inject.Singleton
import com.mtrakr.dao.component.UsersComponent
import com.mtrakr.dao.db.PostgresDBConfigProvider


@Singleton()
class UsersDAO extends UsersComponent with PostgresDBConfigProvider{

  import driver.api._

  private val usersQuery = TableQuery[UsersTable]

  def all = {
    val query = usersQuery.sortBy(_.id.asc.nullsFirst).result
    db.run(query)
  }

}
