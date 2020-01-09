package com.test.learning

object ImmutableCollectionMain {
  def main(args: Array[String]): Unit = {
    val l:List[Int]=List(1,2,3,4) //Index starts from Zero and immutable
    //ListBuffer have to use for mutability
    println("Random Access: "+l(2))
    println("Size: "+l.size)
    println("first Element: "+l.head)
    println("last element: "+l.last)
    println("All but not last: "+l.init)
    println("All but not first: "+l.tail)
    println("Start to given index: "+l.take(2))
    println("Given index to last: "+l.takeRight(2))
    println("To check the element presence: "+l.contains(2))
    println("Min Element: "+l.min)
    println("Min Element: "+l.max)
    println("Sum of Element: "+l.sum)

    val lR=List.range(1,10) // last element excluded
    println("print range list: "+lR)

    val lROverload=List.range(1,10,2) //increments by 2(3rd param)

    println("print overloaded range list: "+lROverload)

    val lStr=List("Scala","bigdata","Spark","Hadoop")
    println("Iterate over list:-")
    for(each<-lStr) println(each.toUpperCase)
    println()

    println("Print element which contains 'i' char:- ")
    val lOperation=for(each<-lStr if each.contains('i')) yield each.toUpperCase //for yield with iterator guard
    println(lOperation)
    println()

    //val test=for(each<-lStr){if(each.contains('i')) yield each.toUpperCase }

    println("Iterate and create a new list :-")
    val lStrNewYield=for(ele<-lStr) yield ele.toUpperCase
    println(lStrNewYield)
    println()

    //HigherOrder Functions on Collections
    //foreach,map,filter,reduce
    //val lStr=List("Scala","bigdata","Spark","Hadoop")

    lStr.foreach(each=>println(each))
    println()

    val lTransform=lStr.map(_.toUpperCase())//.foreach(each=>println(each))
    println(lTransform)
    println()

    //val lR=List.range(1,10)
    println("Printing Even List using just map without filter:-")
    val lREvenTMap=lR.map(each=>{if(each%2==0) each}) // It returns all the elements if condition not satisfied returns
    println(lREvenTMap)                              // Unit type (i.e,size doesn't change for new Collection)
    println()

    //To overcome the above problem we use filter
    println("Printing Even List using filter:-")
    val lREvenTFilter=lR.filter(each=>each%2==0).map(each=>each)
    println(lREvenTFilter)
    println()

    println("Printing Odd List using filterNot:-")
    val lROddTFilter=lR.filterNot(each=>each%2==0).map(each=>each)
    println(lROddTFilter)
    println()

    println("Printing to UpperCase and Size in Tuple")
    //val lStr=List("Scala","bigdata","Spark","Hadoop")
    val lTransTup=lStr.map(s=>(s.toUpperCase(),s.length)) // Returing list of tuple
    println(lTransTup)
    println()

    println("From above List tuple print size greater than 5")
    println(lTransTup.filter(_._2>5))
    println()

    println("Printing the categorized list")
    val lListTuple=List(("Sachin",40),("sehwag",30),("test",15),("kapil",70))
    def category(age:Int): String={
      if(age<20){
        return "teen"
      }else if(age<60){
        return "adult"
      }
      "old"
    }
    println(lListTuple.map(each=>(each._1,each._2,category(each._2))))
    println()

    val lRedData=List.range(1,11)
    println("printing multiplying of all numbers using reduce:-")
    //println(lRedData.sum) this can also be used for sum,product for multiply
    println(lRedData.reduce(_*_))  //lRedData.reduce((accumulator,eachElement)=>accumulator*eachElement)
    println(lRedData.reduce(_ max _)) // Infix notation
    println(lRedData.reduce(_ min _))
    println()

    println("Printing sum of even numbers using reduce:-")
    println(lRedData.filter(_%2==0).reduce(_+_))
    println()

    //val lStr=List("Scala","bigdata","Spark","Hadoop")
    println("Printing concat of Strings using reduce:-")
    println(lStr.reduce(_ concat "|" concat  _))
    println()

    println("Printing Concat of Strings using method with reduce:-")
    def concat_ws(delim:String,str:String*):String={
      str.reduce((s1,s2) =>s1 concat delim concat s2) // Here internally str is an Array,all collection higher order
      // methods are available in array but it is not a collection
    }
    println(concat_ws("_","hello","scala","world"))
    println()

    println("Printing Count of Even numbers in the List using Higher Order Methods(HOM):-")
    //val lRedData=List.range(1,11)
    println("using filter and Size methods:- "+lRedData.filter(_ %2==0).size)
    //or
    println("using count HOM:- "+lRedData.count(_%2==0))
    println()

    println("Exists HOM usage:- ")
    println(lRedData.exists(_==11)) //println(lRedData.exists(each=>each==11))
    println()

    println("Using partition HOM on list to extract Even and Odd :-")
    println(lRedData.partition(_%2==0)) //return tuple(condition_true[data],condition_false[data])
    println()

    println("Extracting above to sperate variable members:- ")
    val (even,odd)=lRedData.partition(each=>each%2==0)
    println("Even:- "+even)
    println("Odd:- "+odd)
    println()

    println("Combining Even Odd in the above:- ")
    println(even.concat(odd)) // from 2.13 we need to use concat instead of union
    println()

    println("Intersect two member collections:- ")
    println(even intersect odd)
    println()

    println("Distinct in even member collections:- ")
    println(even.distinct )
    println()

    val lTest=List(2,1,4,5,1,2,2)
    println("lTest List Data:- "+lTest)
    println()

    println("Remove Even from lTest:- ") //Note: only the same num of elements are removed not duplicates
    println(lTest diff even)
    println()

    println("Using GroupBy with lTest:-")
    println(lTest.groupBy(each=>each))
    println("Extract Keys diff Types with size value greater than 1 :- ")
    val dupliEle=lTest.groupBy(each=>each).filter(t=>t._2.size>1)
    dupliEle.foreach(t=>print(t._1))
    println(dupliEle.map(_._1))
    println(dupliEle.keys)
    println()

    //val lTest=List(2,1,4,5,1,2,2)
    // 0 1 2 3 4 5 6
    println("Using slice with lTest:- "+lTest.slice(0,5)) //exclusive 5
    println()

    println("Printing aggregating with seed value using fold:-")
    println("Aggregation using reduce:- "+lTest.reduce(_+_))
    println("Aggregation using fold:- "+lTest.fold(100)(_+_))
    println()


    //Map Operations - Map is extension to Set where it allows data to be stored in the form of key value pairs
    // Key is unique and value can be duplicated,access to value is done through key

    val mapData=Map(1->"Scala",2->"Spark",3->"bigdata",4->"hadoop")

    println("Printing Key value acess of Map in diff forms:-")
    println("value with key 1:- "+mapData(1)) // It will return Exception if key doesn't exist
    println("value with key 2:- "+mapData.get(2).get) // Safe to use even key doesn't exist,it return option(some,none)
    println("value with key 3:- "+mapData.getOrElse(3, "**No such key**"))
    println("Access keys from Map:- "+mapData.keys)
    println("Access value from Map:- "+mapData.values)
    println()

    println("Using map HOM operation on Map collection:-")
    println(mapData.map(each=>(each._1,each._2.toUpperCase())))
    println()

    println("Using mapValues HOM operation on Map collection:-")
    println(mapData.view.mapValues(_.toUpperCase())) // from 2.13 we need to access mapValues instead
    println()                                       // of using mapValues directly

    //val lR=List.range(1,10)
    //val lStr=List("Scala","bigdata","Spark","Hadoop")
    println("Conversion of list to Map:-")
    println("First conv to tuples and then to Map:- "+lR.map(each=>(each,each*2)).toMap)
    val createMapFromTwoList=lR.zip(lStr)
    println("Merge two lists to Key Value pair:- "+createMapFromTwoList)
    println("Merge two Lists , covering size differences:- "+lR.zipAll(lStr,2,3))
    println("Convert Map into two list:- "+createMapFromTwoList.unzip)
    println()

    //vector
    val vec=Vector(5,6,9,3,8,2)
    println("Displaying contents of a vector:- "+vec)
    println("Display 5th element in a vector:- "+vec(4))
    println()

    //Range collection
    val rngTo=1 to 10
    println("printing range 1 to 10:- "+rngTo)
    val rngUntil= 1 until 10
    println("printing range 1 until 10:- "+rngUntil)
    val rngC='a' to 'z'
    println("printing range a to z :- "+rngC)
    val rngCFact='a' to 'z' by 2
    println("printing range a to z with factor:- "+rngCFact)
    val rngVec=rngTo.map(_+10)
    println("Vector is generated when we do mmanipulations on range:- "+rngVec)
    println()

    //Array
    val arr=Array(1,5,8)
    println("printing array:- "+arr)
    arr(0)=3
    println("printing after updating array:- "+arr)
    println()

    println("printing using drop method (takes i/p no.of elemnts to drop as arg) on array" +
      "(drops left to right gives new array):- "+arr.drop(1))
    println()





  }
}