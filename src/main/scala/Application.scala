import java.sql.Timestamp

import com.mtrakr.dao.UsersDAO
import com.mtrakr.injecter.Inject
import com.mtrakr.models.{Users, UsersDetails}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Application extends App{

  val usersDAO: UsersDAO = Inject[UsersDAO]
  val date = new Timestamp(System.currentTimeMillis)

  // Insert Into Users Table
  val usersDetailsObj = UsersDetails(Some("Test"), "test@gmail.com", date, None, true, None, None)
  val usersObj = Users(0L, usersDetailsObj)
  val insertResult = usersDAO.insert(usersObj)
  println("Records inserted at  >>>>>>>>" + Await.result(insertResult, Duration.Inf))
}
