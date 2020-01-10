package com.test.learning

object MultiInheritMain {
  def main(args: Array[String]): Unit = {
    println("In Multi Inherit Main Example")
    var subObj001 = new MultiTestClass_001
    subObj001.displayInfo()
    subObj001.grantInsurence()
    subObj001.interest()
  }
}
