package com.test.learning

import scala.collection.immutable.HashMap
import scala.io.Source

//Print CustID and there spending price (total)
/*C:\Drive-D\IntelliJ_Workspace\ScalaTest001\resources\transactionData.csv
 TxID   custID    itemID    price
  100     ,1       ,111    ,400.00
  112     ,2       ,123    ,500.00
  113     ,1       ,444    ,600.00
  367     ,3       ,827    ,350.00
  114     ,2       ,555    ,1600.00
  912     ,3       ,208    ,200.00*/
object TxCustmerDataGrpMain {
  def main(args: Array[String]): Unit = {
    val fileRead = Source.fromFile("C:\\Drive-D\\IntelliJ_Workspace\\ScalaTest001" +
      "\\resources\\transactionData.csv")
    val eachLineLst: List[String] = fileRead.getLines().toList
    val listWithTplVal = eachLineLst.map(each => {
      val splits = each.split(",")
      (splits(1).toInt, splits(3).toDouble)
    })
    val consolidatedKeyValPair = listWithTplVal.groupMapReduce(_._1)(_._2)(_ + _)
    println(consolidatedKeyValPair)
  }
}
