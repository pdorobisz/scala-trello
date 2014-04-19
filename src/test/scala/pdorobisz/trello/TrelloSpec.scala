package pdorobisz.trello

import org.specs2.mutable._
import scala.concurrent.Future
import pdorobisz.trello.data.Card
import pdorobisz.trello.testdata.TestCardData

class TrelloSpec extends Specification with TrelloSpecHelper {

  private val cardId = "u34uf93"

  private val trello = new Trello(appKey, token) {
    override def sendReceiveFunc() = createSendReceiveFunc(TestCardData.json)
  }

  "Trello instance" should {
    val future: Future[Card] = trello.getCard(cardId)

    "create card request" in {
      import pdorobisz.trello.internal.UrlBuilder._
      val expectedUrl = s"$apiUrl/$apiVersion/cards/$cardId?key=$appKey&token=$token"
      requestedUri.toString must be equalTo expectedUrl
    }
    "return card" in {
      val receivedCard: Card = awaitResult(future)
      receivedCard must be equalTo TestCardData.card
    }
  }
}
