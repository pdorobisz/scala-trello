package pdorobisz.trello.data

import org.scalaequals.ScalaEquals

class Card(
            val id: String = "",
            val closed: Boolean = false,
            val name: String = "",
            val desc: String = "",
            val idBoard: String = "",
            val idChecklists: Seq[String] = Seq(),
            val idList: String = "",
            val idMembers: Seq[String] = Seq(),
            val idShort: Int = 0,
            val manualCoverAttachment: Boolean = false,
            val pos: Int = 0
            ) extends TrelloObject {

  override def equals(other: Any): Boolean = ScalaEquals.equal

  def canEqual(other: Any): Boolean = ScalaEquals.canEquals

  override def toString: String = ScalaEquals.genString
}