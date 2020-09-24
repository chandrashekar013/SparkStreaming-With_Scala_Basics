package spark

import org.apache.spark._
import org.apache.spark.SparkContext._

object friendsByAge extends App {

  def parseLines(line: String) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val noOfFriends = fields(3).toInt
    (age, noOfFriends)
  }

  val sc = new SparkContext("local[*]", "friendsByAge")
  val lines = sc.textFile("file:///E:/BigData/Scala/material/fakefriends.csv")
  val parseData = lines.map(parseLines)
  val friendsByAge = parseData.mapValues(x => (x, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
  val avgByAge = friendsByAge.mapValues(x => x._1 / x._2)
  val results = avgByAge.collect()
  results.sorted.foreach(println)


}
