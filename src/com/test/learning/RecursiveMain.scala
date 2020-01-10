package com.test.learning

import scala.annotation.tailrec
import scala.io.StdIn

object RecursiveMain {
  def main(args: Array[String]): Unit = {
    println("Enter number to find factorial recursively:- ")
    val rdInt: Int = StdIn.readInt()
    println("Result is:- " + factorialTail(rdInt))
  }

  def factorial(num: Int): BigDecimal = {
    if (num < 2) return num
    num * factorial(num - 1)
  }

  @tailrec //not mandatory
  def factorialTail(num: Int, result: BigDecimal = 1): BigDecimal = {
    if (num < 2) return result
    factorialTail(num - 1, result * num)
  }

}
