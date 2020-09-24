package basics

object oop extends App {
  val p = new Person(12, "Joe")
  println(p.age)
  p.simpleMethod(14)

  class Person(val age: Int, name: String) {

    /*method */
    def simpleMethod(age: Int): Unit = {
      println(age)
    }
  }

}
