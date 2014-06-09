object PatternMatch {

  val list = Seq(1,"String",1L,Some("some"))

  def pattern_match(v:Option[String]) {
    v match {
      case Some(x) => println(x)
      case _ =>
    }
  }

  /**
   * こう書きたくなるけどもっと良いやり方がある
   * （intellijが教えてくれるけどね）
   */
  def map_match_bad_pattern() {
    list.map{ i =>
      i match {
        case x:Int => println(s"is Int: $x")
        case x:String => println(s"is String: $x")
        case x:Long => println(s"is Long: $x")
        case _ => println("unknown:")
      }
    }
  }

  /**
   * もっと良いやり方
   */
  def map_match_good_pattern() {
    list.map {
      case x: Int    => println(s"is Int: $x")
      case x: String => println(s"is String: $x")
      case x: Long   => println(s"is Long: $x")
      case _         => println("unknown:")
    }
  }

  /**
   * パターンマッチ+IF
   */
  def pattern_match_if() {
    (1 to 10) foreach {
      case x if x % 2 == 0 => println(s"偶数:$x")
      case x if x % 2 != 0 => println(s"奇数:$x")
    }
  }

}
