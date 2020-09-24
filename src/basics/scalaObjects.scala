package basics

object scalaObjects extends App {

  //Companions when both object and class are of same scope with in object

  object Person {
    // contains static  level elements
    var height = 2
  }

  class Person(height: Int) {
    // contains instance level elements
    def printHeight(): Unit = println(height)
  }

  // invocation of Object Person element
  val p = Person
  p.height = 4
  println(p.height) //Doesnt contain constructor (o:p:4)

  val p1 = Person
  println(p1.height) // Will print same as p because it is class level (o:p:4)

  // invocation of instance of Person class
  val pO = new Person(12)
  println(pO.printHeight()) // o:p: 12

  val pO1 = new Person(14)
  println(pO1.printHeight()) // o:p: 14
}
