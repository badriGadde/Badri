package com.test.learning

object HighOrderMain {
  def main(args: Array[String]): Unit = {
    println("HigherOrder 1 : " + stringOps("Scala", x => x.toUpperCase()))
    println("HigherOrder 2 : " + stringOps("Scala", _.reverse))
    println("HigherOrder 3 : " + funcMultiType(25, mulBy2)) //It returns empty because it doesn't return anything
    funcMultiType(30, mulBy2)
    println("HigherOrder 4 : " + arthDynamic[Int, Int](10, 20, _ + _))
    println("HigherOrder 5 : " + arthDynamic[Int, Boolean](10, 20, (x1, x2) => x1 < x2))
  }

  def stringOps(src: String, fun: String => String) = fun(src)

  def funcMultiType(src: Int, func: Int => Int) = {
    println(func(src))
  }

  def mulBy2(src: Int): Int = {
    src * 2
  }

  def arthAdd(x1: Int, y1: Int, f: (Int, Int) => Int) = {
    f(x1, y1)
  }

  def arthDynamic[A, B](x1: A, x2: A, func: (A, A) => B) = {
    func(x1, x2)
  }
}

class HighOrderClass {
  def stringOps(src: String, fun: String => String) = fun(src)
}