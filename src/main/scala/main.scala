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
  }

  def queryStringReplacePage(queryString:String, page:Int):String = {
    //key=valueの形で配列に分解し、page=?を取り除く（関数分解したほうがいいのかなー）
    val trim_page_param: Seq[String] = queryString.split('&').filter(i => !(i.matches("""^page=[0-9]+$""")))
    // > WrappedArray(hoge=abc, count=15)

    //page=2を結合し、&区切りでクエリストリング生成
    (trim_page_param ++ Seq(s"page=$page")).mkString("&")
  }

}

