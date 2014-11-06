import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.routing.RoundRobinRouter

object akka {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val router = system.actorOf(Props[HelloActor].withRouter(RoundRobinRouter(2)))

    while(true) {
      router ! "Hello1"
      router ! "Hello2"
      router ! "Hello3"
      Thread.sleep(5000)
    }
//    system.shutdown
  }

  class HelloActor extends Actor {
    def receive = {
      case msg =>
        Thread.sleep(1000)
        println("message: " + msg)
    }
  }

}

