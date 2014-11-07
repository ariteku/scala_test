import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import scala.util.Random

object akkaInfiniteLoop {
  case class Watch()
  case class Process()

  val rand = new Random

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val watcherActor = system.actorOf(Props[WatcherActor])
    
    watcherActor ! Watch
  }

  class WatcherActor extends Actor {
    def receive = {
      case Process =>
        println("Process..")
        Thread.sleep(500L)
        self ! Watch

      case Watch =>
        println("Watching!")
        Thread.sleep(1000L)
        rand.nextInt(2)+1  match {
          case 1 => self ! Process
          case _ => self ! Watch
        }
    }
  }
}
