import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor

object akka {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val helloActor = system.actorOf(Props[HelloActor])
    
    helloActor ! "Hello"
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
