package curry

object curry {
  def main(args: Array[String]) = {
    // 2引数関数
    val f = (x: Int, y: Int) => x + y

    // 自分でカリー化
    def doCurry(x: Int) = (y: Int) => f(x, y)
    val curried = doCurry(1)
    Console println s"curry: ${curried(3)}"

    // curriedメソッドでカリー化する
    val c = f.curried
    Console println s"curry: ${c(1)(2)}"

    val c2 = c(2)
    Console println s"curry: ${c2(2)}"
  }
}
