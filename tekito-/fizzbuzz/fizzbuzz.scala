object fizzbuzz {
  def main(args: Array[String]) {
    (for {
      i <- 1 to 100
    } yield {
      i match {
        case x if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
        case x if x % 3 == 0 => "Fizz"
        case x if x % 5 == 0 => "Buzz"
        case x => x.toString
      }
    }) foreach println
  }
}
