import com.mtrakr.dao.UsersDAO
import com.mtrakr.injecter.Inject

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends App{

  val usersDAO: UsersDAO = Inject[UsersDAO]

  usersDAO.all map{ x =>
    println("Get number of records in A/C trans" + x.length)
  }


}
