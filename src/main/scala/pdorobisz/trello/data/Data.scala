package pdorobisz.trello.data

sealed trait TrelloObject

case class Card(name: String, desc: String) extends TrelloObject
