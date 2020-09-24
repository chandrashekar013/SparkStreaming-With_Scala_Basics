package spark

import org.apache.spark._
import org.apache.spark.SparkContext._

object wordCount extends App {

  val sc = new SparkContext("local[*]", "wordCount")
  val lines = sc.textFile("file:///E:/BigData/Scala/material/book.txt")
  val words = lines.flatMap(x => x.split("\\W+"))
  val countWords = words.countByValue()
  countWords.foreach(println)

}
