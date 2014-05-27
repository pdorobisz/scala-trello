package pdorobisz.trello

import org.specs2.mutable._
import pdorobisz.trello.internal.ResourceNames._
import pdorobisz.trello.internal.UrlBuilder._
import spray.http.{StatusCodes, HttpMethods}
import pdorobisz.trello.testutil.{TrelloContext, TrelloSpecHelper}
import TrelloSpecHelper._

class TrelloChecklistsSpec extends Specification {

  private val checklistId = "u34uf93"

  "deleteChecklist" should {
    "create request" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK)
      trello.deleteChecklist(checklistId)
      val expectedUrl = s"$apiUrl/$apiVersion/$Checklists/$checklistId?key=$appKey&token=$token"
      createdHttpRequest must beRequest(HttpMethods.DELETE, expectedUrl)
    }

    "return true when checklist was deleted" in new TrelloContext {
      val trello = createTrello(StatusCodes.OK)
      trello.deleteChecklist(checklistId) must be_==(true).await
    }

    "return false when checklist was not found" in new TrelloContext {
      val trello = createTrello(StatusCodes.NotFound)
      trello.deleteChecklist(checklistId) must be_==(false).await
    }
  }
}
