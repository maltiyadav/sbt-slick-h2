package dao

import com.google.inject.Singleton
import models.Users
import dao.component.UsersComponent
import dao.db.H2DBConfigProvider

import scala.concurrent.Future


@Singleton()
class UsersDAO extends UsersComponent with H2DBConfigProvider{

  import driver.api._

  private val usersQuery = TableQuery[UsersTable]

  def insert(users: Users): Future[Long] ={
    db.run((usersQuery returning usersQuery.map(_.id)) += users)
  }

  def all: Future[Seq[Users]] = {
    val query = usersQuery.sortBy(_.id.asc.nullsFirst).result
    db.run(query)
  }

}
