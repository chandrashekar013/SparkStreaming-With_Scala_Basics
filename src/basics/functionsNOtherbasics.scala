package basics

import scala.util.Random

object functionsNOtherbasics extends App {

  /*basic function which parameters and return */
  def firstMethod(a: Int, b: Int): Int = {
    a + b
  }

  println(firstMethod(2, 3))

  /*function within another function*/
  def secondMethod(a: String): String = {
    def thirdMethod(b: String) = a + b

    thirdMethod(" again this")
  }

  println(secondMethod("this"))

  /*call by name '=>'*/
  def callByName(x: => Long): Unit = {
    println("1st time" + x) /*Both these values are diff since usage of => will cause arg impl at run time*/
    println("2nd time" + x)
  }

  callByName(System.nanoTime())

  /*default and named arguments*/
  def defaultArg(height: Double = 5.5, weight: Double): Unit = {
    println("height: " + height + " weight: " + weight)
  }

  defaultArg(6.5, 24)

  def namedArg(height: Double = 6.75, weight: Double): Unit = {
    println("height: " + height + " weight: " + weight)
  }

  namedArg(weight = 45)

  /*Scala Specific utilities*/
  val string: String = "This is String"
  println(string.reverse) /*o.p:gnirtS si sihT*/
  println("e" +: string :+ "f") /*prefix and suffix*/
  println(string.take(2)) /*o.p: Th*/

  /*S-interpolator*/
  val age = 23
  val aSentence = s"my age is $age"
  println(aSentence) /*to print only string with replacer*/

  /*f -interpolator*/
  val height = 153.4f
  val hSentence = f"my height is $height%2.2f cms"
  println(hSentence) /*to print string which contains replacer with formatting*/

  /*raw-interpolator*/
  val rSentence = raw"this string contains escape \n characters"
  println(rSentence) /*to print string as is even if it contains escape char*/

  // pattern matching
  val random = new Random()
  val x = random.nextInt(8)

  val desc = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "any other"
  }
  println(x)
  println(desc)
}


