package basics

object collections extends App {

  //seq
  val aSeq = Seq(1, 2, 8, 4)
  println(aSeq)
  println(aSeq.reverse)
  println(aSeq(2))
  println(aSeq ++ Seq(5, 6))
  println(aSeq.sorted)
  aSeq.foreach(println)

  //range
  val aRange: Seq[Int] = 1 until 10 // 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //list
  val aList = List(1, 2, 3, 4)
  val prepend = 12 :: aList //will  prepend 12 into list
  val aPreAppend = 14 +: aList :+ 45
  println(aPreAppend)


  val words = List.fill(5)("words")
  println(words)

  val aWor = List("hello", "hey", "der")
  println(aWor.groupBy(x => x.charAt(0)))

  //Arrays
  val num = Array(2, 3, 5, 3)
  val arrayElem = Array.ofDim[Int](3)
  arrayElem(2) = 1


  //Vector
  val vec = Vector(1, 2, 3)
  println(vec)


  //Tuples
  val tup = new Tuple3(2, "hello", "222")
  println(tup)
  println(tup._1)
  println(tup.copy(_2 = "Hey"))

  //maps
  val aMap: Map[String, Int] = Map()
  val bMap = Map((1, "hello"), (2, "Java"), 3 -> "welcome") // 3 '->' welcome will give tuple
  println(bMap)

  println(bMap.contains(2))
  println(bMap(2))

  val cMap = 4 -> "hey"
  val dMap = bMap + cMap
  println(dMap)
  // println(dMap(3)) // will throw error if not found
  println("None" + dMap.get(6)) // will return None if not found.Will be useful to call whenever we expect null


  println(dMap.map(x => x._1.toLong -> x._2.toLowerCase))
  println(dMap.filter(x => x._2.startsWith("hello")))
  println(dMap.toList)

  //Option
  def nullReturn(): String = null

  println(Option(nullReturn())) //will return None if not found.Will be useful to call whenever we expect null

}

