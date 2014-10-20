import scala.concurrent.duration.Duration
import scala.concurrent._
import ExecutionContext.Implicits.global

object future01 {

  /** main */
  def main(args: Array[String]) {
    println("*** CPUのスレッド数より多く並列処理を走らせると詰まる ***")

    val f1 = Future{ Thread.sleep(1500); println("end1"); 1 }
    val f2 = Future{ Thread.sleep(1500); println("end2"); 1 }
    val f3 = Future{ Thread.sleep(1500); println("end3"); 1 }
    val f4 = Future{ Thread.sleep(1500); println("end4"); 1 }
    val f5 = Future{ Thread.sleep(1500); println("end5"); 1 }
    val f6 = Future{ Thread.sleep(1500); println("end6"); 1 }
    val f7 = Future{ Thread.sleep(1500); println("end7"); 1 }
    val f8 = Future{ Thread.sleep(1500); println("end8"); 1 }
    val f9 = Future{ Thread.sleep(1500); println("end9"); 1 }

    val f = for {
      fu1 <- f1
      fu2 <- f2
      fu3 <- f3
      fu4 <- f4
      fu5 <- f5
      fu6 <- f6
      fu7 <- f7
      fu8 <- f8
      fu9 <- f9
    } yield {
      s"all end !"
    }
    val ret = Await.result(f, Duration.Inf)
    println(ret)
  }
}
