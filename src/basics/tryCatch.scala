package basics

object tryCatch extends App {
  val a = 1
  val b = 0

  try {
    println(a / b)
  }
  catch {
    case e: ArithmeticException => println("exception handled")
  }

}
