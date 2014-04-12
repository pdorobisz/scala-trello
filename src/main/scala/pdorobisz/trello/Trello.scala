package pdorobisz.trello

import akka.actor.ActorSystem
import pdorobisz.trello.internal.UrlBuilder
import scala.concurrent.Future
import spray.client.pipelining._
import spray.http.HttpRequest
import pdorobisz.trello.data._
import spray.httpx.SprayJsonSupport._

class Trello private(appKey: String, token: String) {

  val urlBuilder = UrlBuilder(appKey, token)


  import pdorobisz.trello.internal.TrelloJsonProtocol._
  implicit val system = ActorSystem()

  import system.dispatcher

  def card(id: String): Future[Card] = {
    val pipeline: HttpRequest => Future[Card] = sendReceive ~> unmarshal[Card]
    val url = urlBuilder.build("cards", id)
    pipeline(Get(url))
  }
}

object Trello {

  def apply(appKey: String, token: String) = new Trello(appKey, token)
}
