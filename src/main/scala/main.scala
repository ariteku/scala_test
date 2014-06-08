//import scalikejdbc._
import util._

object main {
  def main(args: Array[String]) = {
    //test
    Functions.func_literal2(Some("1234"))

    //test map operation
    MapOperation.print()

    //test ケースクラスをデータ表示用のMapに変換して表示
    CaseClassToMap.usersPrint()
  }
}



