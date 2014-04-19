package pdorobisz.trello.internal

import spray.http.Uri

class UrlBuilder private(appKey: String, token: String) {

  import UrlBuilder._

  def build(resource: String, id: String): Uri = Uri(s"$apiUrl/$apiVersion/$resource/$id?key=$appKey&token=$token")
}

object UrlBuilder {
  val apiUrl = "https://api.trello.com"
  val apiVersion = "1"

  def apply(appKey: String, token: String): UrlBuilder = new UrlBuilder(appKey, token)
}