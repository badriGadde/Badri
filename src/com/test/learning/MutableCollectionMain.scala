package com.test.learning

import scala.collection.mutable._
//aliasing
//import scala.collection.mutable.{Set=>MSet,Map=>MMap}

object MutableCollectionMain {

  def main(args: Array[String]): Unit = {

    //Set
    val s=Set(1,2,3,4)
    println("printing mutable Set :- "+s)
    println()

    //List
    val lbuff=ListBuffer[String]() // or val lbuff=LisBuffer("Scala","Spark")
    lbuff.addOne("Scala")
    lbuff.addOne("Spark")
    println("printing mutable List :- "+lbuff)
    lbuff.prepend("prepend")
    println("printing mutable List after modifying(prepend) :- "+lbuff)
    lbuff.append("append")
    println("printing mutable List after modifying(append) :- "+lbuff)
    lbuff.insert(1,"insert")
    println("printing mutable List after modifying(insert) :- "+lbuff)
    lbuff.update(1,"insertToUpdate")
    println("printing mutable List after modifying(update) :- "+lbuff)
    lbuff.remove(1)
    println("printing mutable List after modifying(remove) :- "+lbuff)
    println()

    //Map
    val mp=Map(1->"scala") //or val mp=Map((1,"scala"))
    println("printing mutable Map:- "+mp)
    mp.put(2,"spark")
    println("printing map after modifying(put) :- "+mp)
    mp+=3 -> "bigdata"
    println("printing map after modifying(+=) :- "+mp)
    mp.remove(3) //or mp-=3
    println("printing map after modifying(remove) :- "+mp)
    mp-=2
    println("printing map after modifying(-=) :- "+mp)
    mp(1)="scalac"
    println("printing map after modifying(mp(1)) :- "+mp)
    println()


  }
}
