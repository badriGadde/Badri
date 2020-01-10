package com.test.learning

class MagicApply {
  def apply(): Unit = println("In MagicApply Class")
}

object MagicApplyMain {

  def main(args: Array[String]): Unit = {
    var magicApp = new MagicApply
    magicApp()
  }

}