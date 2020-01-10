package com.test.learning

trait Bank_001 {

  //fields - abstract & non-abstract/concrete
  //methods - abstract & non-abstract(default)

  def info(): Unit = println("This is a bank application")

  def interest()
}

class BankSub_001 extends Bank_001 {
  override def interest(): Unit = println("Interest rate in BankSub_001 is 8%")
}

object BankMain_001 {
  def main(args: Array[String]): Unit = {
    var subObj001: BankSub_001 = new BankSub_001
    subObj001.info()
    subObj001.interest()
  }
}