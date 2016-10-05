package com.mtrakr.dao

import com.google.inject.Guice
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.reflect.ClassTag

class AccountTransactionDAOTest extends FunSuite with TestDBHelper{

  val accountTransactionDAO: AccountTransactionDAO = Inject[AccountTransactionDAO]

  test("get all records"){
    val result = Await.result(accountTransactionDAO.all, Duration.Inf)
    println("result>>>>>>>>>" + result)
    println("length>>>>>>>>>" + result.length)
    assert(result.nonEmpty)
  }

  test("2 must equal 2"){
    assert(2 === 2)
  }

}

object Inject {
  lazy val injector = Guice.createInjector()

  def apply[T <: AnyRef](implicit m: ClassTag[T]): T =
    injector.getInstance(m.runtimeClass).asInstanceOf[T]
}
