package basics

object simpleExercise extends App {

  /* Assign integer to var*/
  var firstInt: Int = 23
  firstInt = 34
  println(firstInt)

  /* Assign integer to val(similar to final in java) */
  val secondInt: Int = 45
  /*secondInt = 23 --> will throw error */
  println(secondInt)

  /* Assign value to string */
  val firstString: String = "This is scala"
  println(firstString)

  /* 2 strings in single line written by ; as separator */
  val fString: String = "fString";
  val sString = "sString"
  println(fString + " " + sString)

  /*Other types*/
  val bool: Boolean = true
  val ch: Char = 'r'
  val long: Long = 2344444
  val float: Float = 23.22f
  val double: Double = 2322.32

  println("bool: " + bool + " char: " + ch + " long:  " + long + " float: " + float + " double: " + double)

  /*expressions*/
  val exp1 = firstInt + secondInt
  println(exp1)

  val exp2 = {
    val y = 32
    val z = 21
    if (z > y) "condition satisfied" else "not satisfied"
  }
  println(exp2)

  val whileExp: Unit = while (firstInt < 10) {
    println("hello")
    firstInt += 1
  }
  println(whileExp) /* Will print Unit*/
}
