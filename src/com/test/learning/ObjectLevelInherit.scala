package com.test.learning

trait ObjLevelInheritTrait_001 {
  def display(): Unit = println("This is ObjLevelInheritTrait_001")

  def testData(): Unit
}

class ObjLevelInheritClass_001 {
  def info(): Unit = println("This is ObjLevelInheritClass_001")
}

object ObjectLevelInheritMain_001 {
  def main(args: Array[String]): Unit = {
    //we can override methods while object creation
    val obj = new ObjLevelInheritClass_001
    obj.info()
    val objInherit = new ObjLevelInheritClass_001 with ObjLevelInheritTrait_001 {
      /*override//not mandatory*/ def testData(): Unit = println("Implemented testData in ObjLevelInheritTrait_001 Obj")
    }
    objInherit.info()
    objInherit.display()
    objInherit.testData()
  }
}