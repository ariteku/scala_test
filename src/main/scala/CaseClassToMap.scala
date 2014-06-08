/**
 * case class から表示用のMapを作成するテスト
 */
object CaseClassToMap {

  //データ作成
  case class user(id:Int, name:String, age:Int)
  val users = List(
    new user(1,"hoge san", 22),
    new user(2,"foo san",  21),
    new user(3,"bar san",  18),
    new user(4,"nyan san", 26)
  )

  //表示する
  //データを作ってview helperとかでテーブルを作りたい場合があると思う
  def usersPrint() {
    val viewData = convertViewData()
    //key一覧
    println(s"keys: ${viewData.head.keys}")

    //value一覧
    viewData.foreach{ u =>
      println(u.values)
    }
  }

  //TODO:流石にkeyを日本語にするのはまずいかな
  def convertViewData(): List[Map[String,String]] = {
    users.map { u =>
      Map[String,String](
        "ID" -> u.id.toString,
        "名前" -> s"${u.name}(${u.age})"
      )
    }
  }
}
