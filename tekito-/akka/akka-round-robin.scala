import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.routing.RoundRobinRouter

object akkaRoundRobin {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")

    // 5個のアクターが立ち上がる
    val router = system.actorOf(Props[HelloActor].withRouter(RoundRobinRouter(5)),"router")
    (1 to 5) foreach {
      i => router ! s"Hello[$i]"
    }
  }

  class HelloActor extends Actor {
    def receive = {
      case msg =>
        while(true) {
          Thread.sleep(1000)
          println("message: " + msg)
        }
    }
  }
}
