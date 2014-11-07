import java.util.Date
import scala.collection.immutable.IndexedSeq
import scala.concurrent._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Random}

object futureOutOfMemory {
  /** main */
  def main(args: Array[String]) {
    Console println "Thread作りすぎてout of memory"
    val f: Future[IndexedSeq[Int]] = Future.sequence {
      for (i <- 1 to 5000) yield {
        Future{ blocking { Thread.sleep(500); println(s"end[$i] "); i} }
      }
    }
    Console println Await.result(f, Duration.Inf)
  }
}
