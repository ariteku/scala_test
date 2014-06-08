/**
 * Mapを操作してみる
 */
object MapOperation {
  //データ作成
  val userMaps = List(
    Map("id" -> 1, "name" -> "hoge san", "age" -> 22),
    Map("id" -> 2, "name" -> "foo san",  "age" -> 21),
    Map("id" -> 3, "name" -> "bar san",  "age" -> 18),
    Map("id" -> 4, "name" -> "nyan san", "age" -> 26)
  )

  //表示する
  def print() {
    println("keys: " + userMaps.head.keys)
    userMaps.foreach { i =>
      println(i.values)
    }
  }
}

