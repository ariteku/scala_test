/**
 * 関数定義の仕方
 */
object Functions {

  //普通の関数宣言
  def func_normal(arg1:String) = {
    println(arg1)
  }

  //関数リテラルを使った宣言
  val func_literal = (arg1:String) => println(arg1)

  //{}ブロックを使う、ついでにOption型を使う
  val func_literal2 = (arg1:Option[String]) => {
    arg1.map(println(_))
  }

}
