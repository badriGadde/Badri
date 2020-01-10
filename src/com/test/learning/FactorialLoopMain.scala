package com.test.learning

import scala.io._

object FactorialLoopMain {
  def main(args: Array[String]): Unit = {
    println("Enter number to find factorial by loop:- ")
    val rdInt: Int = StdIn.readInt()
    println("Result is:- " + factorial(rdInt))
  }

  def factorial(num: Int): BigDecimal = {
    var fact: BigDecimal = 1
    if (num < 2) return fact
    for (each <- 2 to num) {
      fact *= each
    }
    fact
  }
}
