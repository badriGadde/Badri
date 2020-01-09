package com.test.learning

object CurryingMain {
  def main(args: Array[String]): Unit = {
    val  testfun=add(2) _ // It returns a function // curried function
    println(testfun(10.2))
  }

  def add(x:Int)(y:Double)=x+y
}
