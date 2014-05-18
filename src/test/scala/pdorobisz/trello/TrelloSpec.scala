package pdorobisz.trello

import org.specs2.mutable._
import pdorobisz.trello.testdata.TestCardData
import pdorobisz.trello.internal.ResourceNames._
import pdorobisz.trello.internal.UrlBuilder._
import spray.http.{StatusCodes, HttpMethods}
import pdorobisz.trello.TrelloSpecHelper._

class TrelloSpec extends Specification {

  private val cardId = "u34uf93"

  "getCard" should {
    "create request" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK)
      trello.getCard(cardId)
      val expectedUrl = s"$apiUrl/$apiVersion/$Cards/$cardId?key=$appKey&token=$token"
      createdHttpRequest must beRequest(HttpMethods.GET, expectedUrl)
    }
    "return card" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK, TestCardData.json)
      trello.getCard(cardId) must be_==(TestCardData.card).await
    }
  }

  "deleteCard" should {
    "create request" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK)
      trello.deleteCard(cardId)
      val expectedUrl = s"$apiUrl/$apiVersion/$Cards/$cardId?key=$appKey&token=$token"
      createdHttpRequest must beRequest(HttpMethods.DELETE, expectedUrl)
    }
    "return true when card was deleted" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK)
      trello.deleteCard(cardId) must be_==(true).await
    }
    "return false when card was not found" in new TrelloContext {
      val trello = createTrello(StatusCodes.NotFound)
      trello.deleteCard(cardId) must be_==(false).await
    }
  }
}
