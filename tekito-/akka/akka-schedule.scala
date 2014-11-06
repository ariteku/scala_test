import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object akkaschedule {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val helloActor = system.actorOf(Props[HelloActor])

    // Actorをスケジュール実行
    system.scheduler.schedule(1 second, 1 seconds) {
      helloActor ! "time: " + System.currentTimeMillis
    }
  }

  class HelloActor extends Actor {
    def receive = {
      case msg =>
        println("message: " + msg)
    }
  }
}
