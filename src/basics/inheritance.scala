package basics

object inheritance extends App {

  abstract class Animal {
    def eat(): Unit
  }

  trait run { //Similar to interface in java. Will not have constructor
    def speed(): Unit
  }

  trait sit {
    def down(): Unit
  }

  class cat extends Animal with run with sit {
    override def eat(): Unit = println("Hello, this is cat")

    override def speed(): Unit = println("cat with speed 20 kmh")

    override def down(): Unit = println("cat sitting down lazy")
  }

  val c = new cat
  println(c.down())
  println(c.down())


}
