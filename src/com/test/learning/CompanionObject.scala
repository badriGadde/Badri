package com.test.learning


class Animal(name:String){
   def display():Unit={
    println("In display method")
    println("Animal name is: "+name)
  }
}
abstract  class test{
  var abstractColl:Int

}
object Animal{
  def apply(name: String): Animal ={
    //println("Bye")
    println("Hello iam in apply method of Companion Object")
    return new Animal(name)
  }
  def test(): Unit ={
    println("Hello there iam Test")
  }

}
object CompanionObject {

  def main(args: Array[String]): Unit = {
    val eagleAnimal=Animal("Eagle")
    eagleAnimal.display()
    val dogAnimal=new Animal("Dog")
    dogAnimal.display()
    Animal.test()
    val catAnimal=new Animal("cat")
    catAnimal.display()
  }
}
