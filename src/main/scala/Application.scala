import com.mtrakr.dao.AccountTransactionDAO
import com.mtrakr.injecter.Inject

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends App{

  val accountTransactionDAO: AccountTransactionDAO = Inject[AccountTransactionDAO]

  accountTransactionDAO.all map{ x =>
    println("Get number of records in A/C trans" + x.length)
  }


}
