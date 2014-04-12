package pdorobisz.trello.internal

class UrlBuilder private(appKey: String, token: String) {

  def build(resource: String, id: String): String = s"${UrlBuilder.url}/${UrlBuilder.apiVersion}/$resource/$id?key=$appKey&token=$token"
}

object UrlBuilder {
  private val url = "https://api.trello.com"
  private val apiVersion = "1"

  def apply(appKey: String, token: String): UrlBuilder = new UrlBuilder(appKey, token)
}