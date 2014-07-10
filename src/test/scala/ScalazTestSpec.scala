import scalaz._
import Scalaz._
import org.specs2.mutable._

class ScalazTestSpec extends Specification {

  "ScalazTestSepc" should {
    "Some(1).get == 1" in {
      val test = Some(1)
      test.get mustEqual 1
    }
    "Someで包む(Scalazを使った場合)" in {
      val data = 1.some
      data.get mustEqual 1
    }
    "val data = 1.some; data orElse 0.some mustEqual 1.some" in {
      val data = 1.some;
	  data orElse 0.some mustEqual 1.some
    }
    "val data = None; data orElse 0.some mustEqual 0.some" in {
      val data = None
	  data orElse 0.some mustEqual 0.some
    }
  }

}

