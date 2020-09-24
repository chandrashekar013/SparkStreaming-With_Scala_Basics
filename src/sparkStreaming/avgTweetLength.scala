package sparkStreaming

import java.util.concurrent.atomic.AtomicLong

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.twitter.TwitterUtils
import utilities._

object avgTweetLength extends App {

  setTwitterConn()
  val ssc = new StreamingContext("local[*]", "avgTweetLength", Seconds(1))
  val tweets = TwitterUtils.createStream(ssc, None)
  val statutes = tweets.map(x => x.getText())
  val lengths = statutes.map(x => x.length)

  var totalTweets = new AtomicLong(0)
  var totalChars = new AtomicLong(0)

  lengths.foreachRDD((rdd, time) => {
    var count = rdd.count()
    if (count > 0) {
      totalTweets.getAndAdd(count)
      totalChars.getAndAdd(rdd.reduce((x, y) => x + y))

      println("totalTweets:" + totalTweets.get() +
        "totalChars:" + totalChars.get() +
        "avg tweet length:" + totalChars.get() / totalTweets.get())

    }

  })

  ssc.checkpoint("E:\\BigData\\Python\\Programs\\ScalaSpark\\checkout")
  ssc.start()
  ssc.awaitTermination()

}
