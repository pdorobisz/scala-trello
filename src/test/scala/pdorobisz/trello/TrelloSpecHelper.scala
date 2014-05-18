package pdorobisz.trello

import spray.http._
import spray.http.HttpRequest
import org.specs2.mutable.Specification


object TrelloSpecHelper extends Specification {
  def beRequest(expectedHttpMethod: HttpMethod, expectedUrl: String) =
    (r: HttpRequest) => (r.uri.toString must_== expectedUrl) and (r.method must_== expectedHttpMethod)
}
