package basics

object functions extends App {
  //There are functions which can take up to 22 parameters in Scala
  val a: Function1[Int, Int] = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }
  println(a(3))

  val b: Int => Int = new Function1[Int, Int] { //FUnction can also be denoted using Int, Int => Int
    override def apply(v1: Int): Int = v1 * 4
  }
  println(b(5))

  //lambda function
  val c: Int => Int = (v1: Int) => v1 * 4
  println(c(3))

  val d: Int => Int = _ * 4 //same as c

  val e: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val f: (Int, Int) => Int = _ + _ //same as e
  println(e(2, 3))
  println(f(2, 3))

  // Higher order function(HOF)
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 1) x
    else nTimes(f, n - 1, f(x))

  val add = (x: Int) => x + 1
  println(nTimes(add, 10, 1))

}


