package sparkStreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.twitter.TwitterUtils
import utilities._

object popularTweet extends App {

  setTwitterConn()
  val ssc = new StreamingContext("local[*]", "populartweet", Seconds(1))
  val tweets = TwitterUtils.createStream(ssc, None)

  val statutes = tweets.map(x => x.getText())
  val tweetWords = statutes.flatMap(x => x.split(" "))
  val hashtag = tweetWords.filter(x => x.startsWith("#"))
  val hashtagKeyValue = hashtag.map(x => (x, 1))
  val hashtagCounts = hashtagKeyValue.reduceByKeyAndWindow((x, y) => x + y, (x, y) => x - y, Seconds(300), Seconds(15))
  val sortedResult = hashtagCounts.transform(rdd => rdd.sortBy(x => x._2, false))
  sortedResult.print()
  ssc.checkpoint("E:\\BigData\\Python\\Programs\\ScalaSpark\\checkout")
  ssc.start()
  ssc.awaitTermination()


}
