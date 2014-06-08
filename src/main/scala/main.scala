//import scalikejdbc._
import util._

object main {
  def main(args: Array[String]) = {
    //test
    Functions.func_literal3(Some("1234"))

    //test map operation
    //MapOperation.print()
    CaseClassToMap.usersPrint()
  }
}


/**
 * Case Classのデータを表示用に整形するサンプル
 */
object CaseClassToMap {
  case class user(id:Int, name:String, age:Int)
  val users = List(
    new user(1,"hoge san", 22),
    new user(2,"foo san",  21),
    new user(3,"bar san",  18),
    new user(4,"nyan san", 26)
  )

  def usersPrint() {
    val viewData = convertViewData()
    println(s"keys: ${viewData.head.keys}")
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

/**
 * Mapを操作してみる
 */
object MapOperation {
  val userMaps = List(
    Map("id" -> 1, "name" -> "hoge san", "age" -> 22),
    Map("id" -> 2, "name" -> "foo san",  "age" -> 21),
    Map("id" -> 3, "name" -> "bar san",  "age" -> 18),
    Map("id" -> 4, "name" -> "nyan san", "age" -> 26)
  )

  def print() {
    println("keys: " + userMaps.head.keys)
    userMaps.foreach { i =>
      println(i.values)
    }
  }
}

/**
 * 関数定義の仕方
 */
object Functions {

  //普通の関数宣言
  def func(arg1:String) = {
    println(arg1)
  }

  //関数リテラル
  val func_literal = (arg1:String) => println(arg1)

  //関数リテラル. {}ブロック
  val func_literal2 = (arg1:Option[String]) => {
    println(arg1.get)
  }

  val func_literal3 = (arg1:Option[String]) => arg1.map {
    i: String => i.toInt
  }.foreach(i=>println(s"params: $i"))

}
