
// 100円のりんご、200円のもも、150円のレモンを
// それぞれ5個、10個、15個購入した時の値段を求めるようなやーつ
// とあるプログラミング問題で使ったのでメモ
object zip {
  def main(args: Array[String]) {
    val point = List(100, 200, 150)
    val count = List(5, 10, 15)

    val result = point zip count map { case(x, y) => x * y }
    
    val total = result.reduce(_ + _)
    
    Console println total
  }
}
