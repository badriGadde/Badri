package com.test.learning

import scala.io._

object InputOutputMain {

  def main(args: Array[String]): Unit = {
    //Using StdIn
    /*println("Enter data for readInt:-")
    val rdInt=StdIn.readInt()
    println("readInt value:- "+rdInt)
    val rdLine=StdIn.readLine("Enter Data for readLine:- ")
    println("readLine value:- "+rdLine)
    println()*/

    //Using Source
    //C:\Drive-D\IntelliJ_Workspace\ScalaTest001\resources\sample.txt
    println("Reading from  file:-")
    val  rdFile=Source.fromFile("C:\\Drive-D\\IntelliJ_Workspace\\ScalaTest001\\resources\\sample.txt"/*,"UTF-8"*/)
    println(rdFile) // Iterator is a one time use ,we cannot iterate again and again so we use collections for
                    // multiple times processing
    rdFile.getLines.foreach(println(_))
    println()
    println("Using Iterator again:-")
    rdFile.getLines.foreach(println(_)) //Nothing prints
    println()

    println("Converting file content to List:-")
    val  rdFileAgain=Source.fromFile("C:\\Drive-D\\IntelliJ_Workspace\\ScalaTest001\\resources\\sample.txt"/*,"UTF-8"*/)
    val rdFileToListColl=rdFileAgain.getLines.toList
    println(rdFileToListColl)
    println()

    println("Print Word Count for the given File:-")
    val  rdFileForWrdCnt=Source.fromFile("C:\\Drive-D\\IntelliJ_Workspace\\ScalaTest001\\resources\\sample.txt"/*,"UTF-8"*/)
    val splitData=rdFileForWrdCnt.getLines().toList
    println()

    println("Print Word Count for the given File using map HOM :-")
    val eachLine=splitData.map(_.split(" "))
    println(eachLine)
    println(eachLine.flatten)
    eachLine.flatten.groupBy(each=>each).map(each=>(each._1,each._2.size)).
      foreach(each=>println(each._1 +"count is "+each._2))
    println()

    //or forLine(37(val eachLine=splitData.map(_.split(" ")))-39(println(eachLine.flatten)))
    println("Print Word Count for the given File using flatMap HOM :-")
    val eachFlatMap=splitData.flatMap(_.split(" "))
    println(eachFlatMap)
    eachFlatMap.groupBy(each=>each).map(each=>(each._1,each._2.size)).
      foreach(each=>println(each._1 +"count is "+each._2))
    //println(eachFlatMap.size)
    println()



  }
}
