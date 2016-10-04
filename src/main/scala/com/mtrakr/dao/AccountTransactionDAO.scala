package com.mtrakr.dao
import java.sql.Timestamp
import java.util.UUID

import com.google.inject.Singleton
import com.mtrakr.dao.db.PostgresDBConfigProvider
import com.mtrakr.dao.driver.DriverComponent
import com.mtrakr.models.{AccountTransaction, AccountTransactionBase}

import scala.concurrent.Future


trait AccountTransactionComponent { self: DriverComponent =>
  import driver.api._

  class AccountTransactionTable(tag: Tag) extends Table[AccountTransaction](tag, "account_transaction") {
    def id = column[Option[Int]]("id", O.AutoInc, O.PrimaryKey)

    def accountNum = column[Option[String]]("account_num")

    def amount = column[Double]("amount")

    def txnType = column[String]("transaction_type")

    def balance = column[Option[Double]]("balance")

    def smsId = column[Option[UUID]]("sms_id")

    def userId = column[String]("user_id")

    def txnTime = column[Option[Timestamp]]("transaction_time")

    def additionalInfo = column[Option[String]]("extra_info")

    def source = column[String]("source")

    def createdTime = column[Timestamp]("created_ts")

    def lastUpdatedTime = column[Option[Timestamp]]("last_updated_ts")

    def txnMode = column[String]("transaction_mode")

    def beneficiary = column[Option[String]]("beneficiary")

    def documentId = column[Option[Int]]("document_id")

    def expenseCategory = column[Option[String]]("expense_category")

    def clientId = column[Option[Int]]("client_id")

    def status = column[Option[String]]("status")

    def isExpense = column[Boolean]("is_expense")

    def syncType = column[Option[String]]("sync_type")

    def bank = column[Option[String]]("bank")

    def devicesSynced = column[Option[String]]("devices_synced")

    def notes = column[Option[String]]("notes")

    def accountTransactionBase = (id, accountNum, amount, txnType, balance, smsId, userId, txnTime,
      additionalInfo, txnMode, createdTime, lastUpdatedTime,
      beneficiary, source, documentId, expenseCategory, isExpense, notes,
      status, devicesSynced, bank, clientId) <>((AccountTransactionBase.apply _).tupled, AccountTransactionBase.unapply)

    def * = (accountTransactionBase, syncType) <>((AccountTransaction.apply _).tupled, AccountTransaction.unapply)
  }
}

@Singleton()
class AccountTransactionDAO extends AccountTransactionComponent with PostgresDBConfigProvider{

  import driver.api._

  private val accountTransactionQuery = TableQuery[AccountTransactionTable]

  def all: Future[Seq[AccountTransaction]] = {
    val query = accountTransactionQuery.sortBy(_.id.asc.nullsFirst).result
    db.run(query)
  }

}
