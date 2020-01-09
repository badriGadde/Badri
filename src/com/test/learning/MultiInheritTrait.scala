package com.test.learning

trait SuperTraitBank_001 {
    def displayInfo():Unit=println("Super Bank Governing")
    def interest()
}

trait SuperTraitInsurance_001{
  def displayInfo()/*:Unit=println("Super Insurance company")*/
  def grantInsurence()
}
class SuperClass_001{
  /*def displayInfo():Unit=println("Super Class company")*/
}
class MultiTestClass_001 extends SuperClass_001 with SuperTraitBank_001 with SuperTraitInsurance_001 {
  override def interest(): Unit = println("MultiTestClass_001 Interest Rate is 9%")
  override def grantInsurence(): Unit = println("Granting insurance from MultiTestClass_001")
  //override def displayInfo():Unit=super.displayInfo()
}