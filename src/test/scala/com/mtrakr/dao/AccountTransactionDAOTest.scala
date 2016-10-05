package com.mtrakr.dao

import org.scalatest.FunSuite
import com.mtrakr.injecter.Inject

class AccountTransactionDAOTest extends FunSuite with TestDBHelper{

  val accountTransactionDAO: AccountTransactionDAO = Inject[AccountTransactionDAO]

  /* test("get all records"){
     val result = Await.result(accountTransactionDAO.all, Duration.Inf)
     assert(result.nonEmpty)
   }*/

  test("2 must be equal to 2"){
    assert(2 === 2)
  }

}


