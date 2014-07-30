import java.util.Date
import scala.collection.immutable.IndexedSeq
import scala.concurrent._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Random}

object future04 {

  /** main */
  def main(args: Array[String]) {
    println(s"-- start: ${new Date} --")
    f()
    println(s"-- end  : ${new Date} --")
  }

  /** x時間waitする関数 */
  val g = (x: Int) => {
    println(s"wait ${x} sec")
    Thread.sleep(x * 1000)
    x
  }

  /** 非同期処理に同時実行(4秒で終わる) core i7環境 */
  def f()  = {
    val r = new Random
    def rand = r.nextInt(4) + 1

    val fs: Seq[Future[Int]] = for(i <- 1 to 8) yield Future( g(rand) )
    val ret: Future[Seq[Int]] = Future.sequence(fs)

    ret onComplete {
      case Success(x) =>
        val sum = x.reduceLeft(_+_)
        println(s"wait秒数の合計: $sum")
      case Failure(_) => None
    }
    Await.result(ret, Duration.Inf)

  }

/*

実行結果
$ scala future04.scala
-- start: Mon Jul 28 19:19:53 JST 2014 --
wait 2 sec
wait 3 sec
wait 2 sec
wait 3 sec
wait 3 sec
wait 1 sec
wait 1 sec
wait 3 sec
-- end  : Mon Jul 28 19:19:56 JST 2014 --
wait秒数の合計: 18

逐次実行すれば18秒かかるところを、非同期に並列実行して3秒で完了している

*/

}
