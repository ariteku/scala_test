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

    //パターンマッチを試す
    PatternMatch.pattern_match(Some("Stringだよー"))
    PatternMatch.map_match_bad_pattern()
    PatternMatch.map_match_good_pattern()
    PatternMatch.pattern_match_if()

    //ネタがない。。
    //コップ本読めばよかったのか
    //でも今日query stringを分解して再度結合するということをした。
    //HashMapからクエリストリング作る関数探していたけど
    //見つけられなかった…

    //queryStringはplayからreuqest.rawQueryStringとかで取得
    val rowQueryString = "hoge=abc&count=15&page=1"
    val replaceQueryString = queryStringReplacePage(rowQueryString, 2)
    println(replaceQueryString)
    // > hoge=abc&count=15&page=2

    Status.valueOf(2)
    //res1: Status = BLOCKED

    println(s"key:  ${Status.PENDING.key}")
    println(s"value:${Status.PENDING.value}")

  }

  def queryStringReplacePage(queryString:String, page:Int):String = {
    //key=valueの形で配列に分解し、page=?を取り除く（関数分解したほうがいいのかなー）
    val trim_page_param: Seq[String] = queryString.split('&').filter(i => !(i.matches("""^page=[0-9]+$""")))
    // > WrappedArray(hoge=abc, count=15)

    //page=2を結合し、&区切りでクエリストリング生成
    (trim_page_param ++ Seq(s"page=$page")).mkString("&")
  }

}

//列挙型
object Status {
  sealed abstract class Status(val key:Int, val value: String) {}
  case object PENDING  extends Status(0,"申請中")
  case object DENIED   extends Status(1,"否定")
  case object BLOCKED  extends Status(2,"ブロック")
  case object DELETED  extends Status(3,"削除")
  case object CANCELED extends Status(4,"キャンセル")

  val values = Array(PENDING,DENIED,BLOCKED,DELETED,CANCELED)

  //keyから対象を取得
  def valueOf(key:Int):Status = {
    values.filter(i => i.key == key) match {
      case i if i.size == 1 => i.head
      case _ => throw new IllegalArgumentException(s"Status: not such key -> $key")
    }
  }

}

