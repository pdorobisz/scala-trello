package pdorobisz.trello

import akka.actor.ActorSystem
import pdorobisz.trello.internal.UrlBuilder
import scala.concurrent.Future
import spray.client.pipelining._
import spray.http._
import pdorobisz.trello.data._
import pdorobisz.trello.internal.ResourceNames._
import spray.httpx.UnsuccessfulResponseException
import spray.http.HttpRequest
import spray.http.HttpResponse

class Trello(appKey: String, token: String, implicit val actorSystem: ActorSystem = ActorSystem()) {

  import pdorobisz.trello.internal.TrelloJsonProtocol._

  import actorSystem.dispatcher

  val urlBuilder = UrlBuilder(appKey, token)

  protected def sendReceiveFunc(): SendReceive = sendReceive

  def getCard(id: String): Future[Card] = {
    val pipeline: HttpRequest => Future[Card] = sendReceiveFunc ~> unmarshal[Card]
    val url = urlBuilder.build(Cards, id)
    pipeline(Get(url))
  }

  def deleteCard(id: String): Future[Boolean] = {
    val pipeline: HttpRequest => Future[Boolean] = sendReceiveFunc() ~> checkIfExists
    val url = urlBuilder.build(Cards, id)
    pipeline(Delete(url))
  }

  private def checkIfExists: HttpResponse ⇒ Boolean =
    response ⇒
      if (response.status == StatusCodes.OK) true
      else if (response.status == StatusCodes.NotFound) false
      else throw new UnsuccessfulResponseException(response)
}

object Trello {

  def apply(appKey: String, token: String) = new Trello(appKey, token)

  def apply(appKey: String, token: String, actorSystem: ActorSystem) = new Trello(appKey, token, actorSystem)
}
