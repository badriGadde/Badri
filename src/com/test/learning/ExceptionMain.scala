package com.test.learning

import scala.util.{Failure, Success, Try}
import scala.io.Source

object ExceptionMain {
  def main(args: Array[String]): Unit = {
    traditionalExceptionHandling()
    scalaTypesOfExceptionHandling()
  }

  def scalaTypesOfExceptionHandling(): Unit = {

    val mp = Map(1 -> "abc", 2 -> "def")

    //Option - Some , None
    println("Printing Types in Exception for Option type")
    println(mp.get(1))
    println(mp.get(3))
    println()

    println("User defined Function with Option ReturnType : " + toInt("10a"))
    println()

    toInt("10") match {
      case Some(value) => println(s"converted to Integer type $value ")
      case None => println("conversion not possible for input")
    }
    println()

    println("Using getOrElse :- " + toInt("12abc").getOrElse("Conversion not compatable for I/P"))
    println()

    println("Using toInt with TryCatch Block Option: " + toIntTryCatchOption("10a").getOrElse("Wrong i/p"))
    println()

    val result = divisionExpHandlingWithEither(10, 0)
    val extracted = if (result.isLeft) result.left.get else result.right.get //2.13.0 we can directly use
    // getOrElse,its right biased
    println("Using division with Either: " + extracted)
    println()

    //or

    println("Using division with Either 2.13: " + result.swap.getOrElse())
    println()

    println("Using Match Case with Either:- ")
    val resultMatch = divisionExpHandlingWithEither(10, 2)
    resultMatch match {
      case Left(a) => println(a)
      case Right(b) => println(s"Result is $b")
    }
    println()

    println("Using toInt with TryCatch Block Either: " + toIntTryCatchEither("10a"))
    println()

    val rdFileWithTrySF = readFileUsingTrySuccessFailure("C:\\Drive-D\\IntelliJ_Workspace\\ScalaTest001" +
      "\\resources\\sample.txt")
    println("Reading Text File ,with Try SuccessFailure(Like Java throws): ")
    rdFileWithTrySF match {
      case Success(value) => println(s"Success Fully Read:- $value")
      case Failure(exception) => println(s"Failed Reading File:- " + exception.getMessage)
    }
    println()

  }

  def readFileUsingTrySuccessFailure(filePth: String): Try[List[String]] = {
    Try {
      Source.fromFile(filePth).getLines().toList
    }
  }

  def divisionExpHandlingWithEither(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("divison by zero is not possible")
    else if (y < 0) Left("Dinomenator can't be negitive")
    else Right(x / y)
  }

  def toIntTryCatchEither(str: String): Either[NumberFormatException, Int] = {
    try {
      Right(Integer.parseInt(str))
    }
    catch {
      case nfe: NumberFormatException => println("Number format Exception"); Left(nfe)
    } finally {
      println("Hello Iam in Finally")
    }
  }

  def toInt(s: String): Option[Int] = {
    val chSeq = s.filterNot(c => c.isDigit)
    if (chSeq.size > 0) {
      return None
    }
    Some(s.toInt)
  }

  def toIntTryCatchOption(str: String): Option[Int] = {
    try {
      Some(Integer.parseInt(str))
    }
    catch {
      case nfe: NumberFormatException => println("Number format Exception"); None
    } finally {
      println("Hello Iam in Finally")
    }
  }


  def traditionalExceptionHandling(): Unit = {
    try {
      throw new RuntimeException //("Hello")
    } catch {
      case exp: IndexOutOfBoundsException => println("Out of Bound Exp")
      case exp: RuntimeException => println("Runtime Exception")
    } finally {
      println("Hello iam finally")
      println()
    }
  }


}
