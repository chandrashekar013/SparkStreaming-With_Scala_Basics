package spark

import scala.math.min
import org.apache.spark._
import org.apache.spark.SparkContext._

object Mintemperature extends App {

  def parseLines(line: String) = {
    val fields = line.split(",")
    val stationId = fields(0)
    val temparatureType = fields(2)
    val temparature = fields(3).toFloat
    (stationId, temparatureType, temparature)
  }

  val sc = new SparkContext("local[*]", "Min")
  val lines = sc.textFile("file:///E:/BigData/Scala/material/1800.csv")
  val parseData = lines.map(parseLines)
  val minTemps = parseData.filter(x => x._2 == "TMIN")
  val stationTemp = minTemps.map(x => (x._1, x._3.toFloat))
  val minTempStationID = stationTemp.reduceByKey((x, y) => min(x, y))
  val results = minTempStationID.collect()

  results.foreach(println)
  for (result <- results.sorted) {
    val station = result._1
    val temp = result._2
    println(station + temp)
  }


}
