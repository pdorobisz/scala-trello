package pdorobisz.trello

import spray.http._
import org.specs2.mock.Mockito
import scala.concurrent.{Future, Await, Promise}
import spray.client.pipelining._
import spray.http.HttpRequest
import spray.http.HttpResponse
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit

trait TrelloSpecHelper extends Mockito {

  val appKey = "wer4397ujh34"
  val token = "3465789tryuio657890"

  private val mockStatus = mock[StatusCode]
  mockStatus.isSuccess returns true

  private val mockResponse = mock[HttpResponse]
  mockResponse.status returns mockStatus

  var requestedUri: Uri = null

  def createSendReceiveFunc(result: String): SendReceive = {
    mockResponse.entity returns HttpEntity(ContentTypes.`application/json`, result.getBytes)

    (req: HttpRequest) => {
      requestedUri = req.uri
      Promise.successful(mockResponse).future
    }
  }

  def awaitResult[T](future: Future[T]): T = Await.result(future, Duration(2, TimeUnit.SECONDS))
}
