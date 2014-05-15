package pdorobisz.trello.testdata

import pdorobisz.trello.data.{CheckItemState, Badge, Label, Card}
import org.joda.time.DateTime

object TestCardData {

  val card = new Card(
    id = "sdf987u3j",
    closed = false,
    dateLastActivity = DateTime.parse("2013-06-21T08:00:21.412Z"),
    name = "test card",
    desc = "this is a test card",
    due = DateTime.parse("2014-05-14T11:15:00.000Z"),
    idBoard = "798dsf37989",
    idChecklists = Seq("qw3", "er3"),
    checkItemStates = Seq(CheckItemState("430e34", "complete"), CheckItemState("5e38e9", "complete")),
    labels = Seq(Label("green", "green label name"), Label("yellow", "yellow label name")),
    idList = "6yui9087y",
    idMembers = Seq("iu876tyu"),
    idShort = 78,
    manualCoverAttachment = false,
    pos = 22345,
    shortUrl = "https://trello.com/c/uNd3s",
    url = "https://trello.com/c/uNd3s/78-test-card",
    badges = Badge(votes = 1, viewingMemberVoted = false, subscribed = false, fogbugz = "", checkItems = 3, checkItemsChecked = 2,
      comments = 1, attachments = 2, description = true, due = DateTime.parse("2014-05-14T11:15:00.000Z"))
  )

  val json =
    s"""
      {
      |	"id" : "${card.id}",
      |	"badges" : {
      |		"votes" : ${card.badges.votes},
      |		"viewingMemberVoted" : ${card.badges.viewingMemberVoted},
      |		"subscribed" : ${card.badges.subscribed},
      |		"fogbugz" : "${card.badges.fogbugz}",
      |		"checkItems" : ${card.badges.checkItems},
      |		"checkItemsChecked" : ${card.badges.checkItemsChecked},
      |		"comments" : ${card.badges.comments},
      |		"attachments" : ${card.badges.attachments},
      |		"description" : ${card.badges.description},
      |		"due" : "${card.badges.due}"
      |	},
      |	"checkItemStates" : [{
			|			"idCheckItem" : "${card.checkItemStates(0).idCheckItem}",
			|			"state" : "${card.checkItemStates(0).state}"
		  |   }, {
			|			"idCheckItem" : "${card.checkItemStates(1).idCheckItem}",
			|			"state" : "${card.checkItemStates(1).state}"
		  |   }
      | ],
      |	"closed" : ${card.closed},
      |	"dateLastActivity" : "${card.dateLastActivity}",
      |	"desc" : "${card.desc}",
      |	"descData" : null,
      |	"due" : "${card.due}",
      |	"idBoard" : "${card.idBoard}",
      |	"idChecklists" : ["${card.idChecklists(0)}", "${card.idChecklists(1)}"],
      |	"idList" : "${card.idList}",
      |	"idMembers" : ["${card.idMembers(0)}"],
      |	"idShort" : ${card.idShort},
      |	"idAttachmentCover" : null,
      |	"manualCoverAttachment" : ${card.manualCoverAttachment},
      |	"labels" : [{
      |			"color" : "${card.labels(0).color}",
      |			"name" : "${card.labels(0).name}"
      |		}, {
      |			"color" : "${card.labels(1).color}",
      |			"name" : "${card.labels(1).name}"
      |		}
      |	],
      |	"name" : "${card.name}",
      |	"pos" : ${card.pos},
      |	"shortUrl" : "${card.shortUrl}",
      |	"url" : "${card.url}",
      |	"membersVoted" : []
      |}
    """.stripMargin
}
