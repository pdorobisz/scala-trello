package pdorobisz.trello

import akka.actor.ActorSystem
import pdorobisz.trello.internal.UrlBuilder
import scala.concurrent.Future
import spray.client.pipelining._
import spray.http.HttpRequest
import pdorobisz.trello.data._

class Trello(appKey: String, token: String, implicit val actorSystem: ActorSystem = ActorSystem()) {

  import pdorobisz.trello.internal.TrelloJsonProtocol._
  import actorSystem.dispatcher

  val urlBuilder = UrlBuilder(appKey, token)

  protected def sendReceiveFunc(): SendReceive = sendReceive

  def getCard(id: String): Future[Card] = {
    val pipeline: HttpRequest => Future[Card] = sendReceiveFunc ~> unmarshal[Card]
    val url = urlBuilder.build("cards", id)
    pipeline(Get(url))
  }
}

object Trello {

  def apply(appKey: String, token: String) = new Trello(appKey, token)

  def apply(appKey: String, token: String, actorSystem: ActorSystem) = new Trello(appKey, token, actorSystem)
}
