package models

import java.sql.Timestamp
import java.util.UUID

case class AccountTransactionBase(
                                   id: Option[Int] = None,
                                   accountNum: Option[String],
                                   amount: Double,
                                   txnType: String,
                                   balance: Option[Double],
                                   smsId: Option[UUID],
                                   userId: String,
                                   txnTime: Option[Timestamp],
                                   additionalInfo: Option[String],
                                   txnMode: String,
                                   createdTime: Timestamp,
                                   lastUpdatedTime: Option[Timestamp],
                                   beneficiary: Option[String],
                                   source: String,
                                   documentId: Option[Int],
                                   expenseCategory: Option[String],
                                   isExpense: Boolean,
                                   notes: Option[String],
                                   status: Option[String],
                                   devicesSynced: Option[String],
                                   bank: Option[String],
                                   clientId: Option[Int])

case class AccountTransaction(
                               accountTransaction: AccountTransactionBase,
                               syncType: Option[String])


