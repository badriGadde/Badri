package com.test.learning

object PartialFunctionMain {
  def main(args: Array[String]): Unit = {
    var partialFun=add(10,_:Int,_:Int)
    println("Printing partial function:- "+partialFun)
    println()
    println("Result of partial Function call:- "+partialFun(10,10))
    println()
    val multipleOf2=factor(2,_:Int)
    println("Printing is a num ,multiple of 2 using patial func:- "+multipleOf2(10))
    println()
    val multipleOf5=factor(5,_:Int)
    println("Printing is a num ,multiple of 5 using patial func:- "+multipleOf2(15))
    println()
  }

  def add(x:Int,y:Int,z:Int): Int ={
    x+y+z
  }

  def factor(x:Int,y:Int):Boolean= y%x==0



}
