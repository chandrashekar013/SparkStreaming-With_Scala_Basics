package spark

import org.apache.spark._
import org.apache.spark.SparkContext._

object RatingsHistogram extends App {
  val sc = new SparkContext("local[*]", "RatingsHistogram")
  val lines = sc.textFile("file:///E:/BigData/Python/Spark/ml-100k/u.data")
  val ratings = lines.map(x => x.toString().split("\t")(2))
  val results = ratings.countByValue()
  val sortedResult = results.toSeq.sortBy(_._1)
  sortedResult.foreach(println)
}
