package sparkStreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._
import utilities._

object printTweets extends App {

  setTwitterConn()
  val ssc = new StreamingContext("local[*]", "printTweets", Seconds(1))
  setupLogging()
  val tweets = TwitterUtils.createStream(ssc, None)
  val text = tweets.map(x => x.getText())

  text.print()

  ssc.start()
  ssc.awaitTermination()

}
