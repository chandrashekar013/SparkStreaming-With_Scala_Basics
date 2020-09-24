package basics

object anonymousClass extends App {

  class animal {
    def eat(): Unit = println("hey, this is animal")
  }

  val a = new animal {
    override def eat(): Unit = println("this is overridden method from anon. class")
  }
  a.eat()
}
