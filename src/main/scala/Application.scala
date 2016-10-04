import com.google.inject.Guice
import com.mtrakr.dao.AccountTransactionDAO

import scala.concurrent.ExecutionContext.Implicits.global
import scala.reflect.ClassTag

object Inject {
  lazy val injector = Guice.createInjector()

  def apply[T <: AnyRef](implicit m: ClassTag[T]): T =
    injector.getInstance(m.runtimeClass).asInstanceOf[T]
}


object Application extends App{

  val accountTransactionDAO: AccountTransactionDAO = Inject[AccountTransactionDAO]

  accountTransactionDAO.all map{ x =>
    println("Get number of records in A/C trans" + x.length)
  }


}
