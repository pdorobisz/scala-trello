package pdorobisz.trello.internal

import spray.json.DefaultJsonProtocol
import pdorobisz.trello.data.Card

object TrelloJsonProtocol extends DefaultJsonProtocol {
  implicit val cardFormat = jsonFormat2(Card)
}
