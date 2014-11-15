package curry

// def で定義した関数をカリー化する
object curry2 {
  def main(args: Array[String]) = {
    // 2引数関数
    def f(x: Int, y: Int) = x + y
    // 部分適応を使って関数オブジェクトにする
    def obj = f _
    // カリー化
    val c = obj.curried
    // 引数を一つ適応
    val c2 = c(2)

    Console println s"c2: ${c2(3)}"
  }
}
