package basics

object shortCut extends App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def unary_! = "this is unary operator"

    def apply() = "this is apply"

  }

  val p = new Person("Joe", "titanic")
  println(p.likes("titanic"))
  println(p likes "titanic") /* infix notation works only if invoking method has one param*/

  println(p.unary_!)
  println(!p) /*+, - ! when used as method name can be used as prefix operator*/

  println(p.apply())
  println(p()) /*invoking only object name with () will invoke apply by default if present*/


}
