package spark

import org.apache.spark._
import org.apache.spark.SparkContext._

object wordCountSort extends App {

  val sc = new SparkContext("local[*]", "wordCount")
  val lines = sc.textFile("file:///E:/BigData/Scala/material/book.txt")
  val words = lines.flatMap(x => x.split("\\W+")).map(x => x.toLowerCase())

  val countWords = words.map(x => (x, 1)).reduceByKey((x, y) => x + y)
  val sortWords = countWords.map(x => (x._2.toInt, x._1)).sortByKey()
  // val countWords = words.countByValue()
  sortWords.foreach(println)

}
