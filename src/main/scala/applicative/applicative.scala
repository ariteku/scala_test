package applicative

import scalaz._
import Scalaz._

// Applicativeに触れてみる
object applicative {
  def main(args: Array[String]) = {
    val a = 2.some <*> { (_: Int) * 2 }.some
    Console println a

    val b = 2.pure[List] <*> List((_: Int) * 2, (_: Int) * 3)
    Console println b
  }
}
