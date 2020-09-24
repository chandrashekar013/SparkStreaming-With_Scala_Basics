package sparkStreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.twitter.TwitterUtils
import utilities._

object saveTweets extends App {

  setTwitterConn()
  val ssc = new StreamingContext("local[*]", "saveTweets", Seconds(1))
  val tweets = TwitterUtils.createStream(ssc, None)
  val statuses = tweets.map(x => x.getText())

  var totalTweets: Long = 0
  statuses.foreachRDD((rdd, time) => {
    if (rdd.count() > 0) {
      val repartitionRdd = rdd.repartition(1).cache()
      repartitionRdd.saveAsTextFile("tweets_" + time.milliseconds.toString())
      totalTweets += repartitionRdd.count()
      println("totaltweets: " + totalTweets)
      if (totalTweets > 5) {
        System.exit(0)
      }
    }

  })
  ssc.checkpoint("E:\\BigData\\Python\\Programs\\ScalaSpark\\checkout")
  ssc.start()
  ssc.awaitTermination()
}
