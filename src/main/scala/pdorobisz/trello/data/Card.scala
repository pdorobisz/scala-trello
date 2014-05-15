package pdorobisz.trello.data

import org.scalaequals.ScalaEquals
import org.joda.time.DateTime
import pdorobisz.trello.util.DateUtil

class Card(
            val id: String = "",
            val closed: Boolean = false,
            val dateLastActivity: DateTime = DateUtil.currentDate,
            val name: String = "",
            val desc: String = "",
            val due: DateTime = null,
            val idBoard: String = "",
            val idChecklists: Seq[String] = Seq(),
            val checkItemStates: Seq[CheckItemState] = Seq(),
            val labels: Seq[Label] = Seq(),
            val idList: String = "",
            val idMembers: Seq[String] = Seq(),
            val idShort: Int = 0,
            val manualCoverAttachment: Boolean = false,
            val pos: Int = 0,
            val shortUrl: String = "",
            val url: String = "",
            val badges: Badge = Badge()
            ) extends TrelloObject {

  override def equals(other: Any): Boolean = ScalaEquals.equal

  def canEqual(other: Any): Boolean = ScalaEquals.canEquals

  override def toString: String = ScalaEquals.genString
}

case class Label(color: String, name: String)

case class CheckItemState(idCheckItem: String, state: String)

case class Badge(votes: Int = 0, viewingMemberVoted: Boolean = false, subscribed: Boolean = false, fogbugz: String = "", checkItems: Int = 0,
                 checkItemsChecked: Int = 0, comments: Int = 0, attachments: Int = 0, description: Boolean = false, due: DateTime = null)
