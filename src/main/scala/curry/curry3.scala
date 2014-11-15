package curry

object curry3 {
  def main(args: Array[String]) = {
    // 2引数関数
    def f(x: Int)(y: Int)(z: Int) = x + y + z

    // 部分適応を使って関数オブジェクトにする
    // > c: Int => (Int => (Int => Int))
    def c = f _

    // 引数を一つ適応
    val c2 = c(2)

    Console println s"c2: ${c2(3)(4)}"
  }
}

