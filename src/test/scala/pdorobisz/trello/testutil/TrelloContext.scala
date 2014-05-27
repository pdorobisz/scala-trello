package pdorobisz.trello.testutil

import spray.http._
import org.specs2.mock.Mockito
import scala.concurrent.Promise
import spray.client.pipelining._
import spray.http.HttpRequest
import spray.http.HttpResponse
import org.specs2.specification.Scope
import pdorobisz.trello.Trello


trait TrelloContext extends Scope with Mockito {
  val appKey = "wer4397ujh34"
  val token = "3465789tryuio657890"

  var createdHttpRequest: HttpRequest = null

  def createTrello(statusCodeToReturn: StatusCode, resultToReturn: String = ""): Trello = {
    new Trello(appKey, token) {
      override def sendReceiveFunc(): SendReceive = {
        val mockResponse = mock[HttpResponse]
        mockResponse.status returns statusCodeToReturn
        mockResponse.entity returns HttpEntity(ContentTypes.`application/json`, resultToReturn.getBytes)

        (req: HttpRequest) => {
          createdHttpRequest = req
          Promise.successful(mockResponse).future
        }
      }
    }
  }
}
