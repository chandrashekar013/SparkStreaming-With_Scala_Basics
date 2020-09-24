package basics

object caseClass extends App {

  case class Animal(speed: Int)

  val a = new Animal(12)
  print(a.speed)
  print(a.toString)
  /*prints meaningful value only for case class*/
  val b = a.copy() /*comes with extra utilities*/
  println(b.speed)

}
