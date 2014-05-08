package pdorobisz.trello.testdata

import pdorobisz.trello.data.Card
import org.joda.time.DateTime

object TestCardData {

  val card = new Card(
    id = "sdf987u3j",
    closed = false,
    dateLastActivity = DateTime.parse("2013-06-21T08:00:21.412Z"),
    name = "test card",
    desc = "this is a test card",
    idBoard = "798dsf37989",
    idChecklists = Seq("qw3", "er3"),
    idList = "6yui9087y",
    idMembers = Seq("iu876tyu"),
    idShort = 78,
    manualCoverAttachment = false,
    pos = 22345)


  val json =
    s"""
      {
      |	"id" : "${card.id}",
      |	"badges" : {
      |		"votes" : 0,
      |		"viewingMemberVoted" : false,
      |		"subscribed" : false,
      |		"fogbugz" : "",
      |		"checkItems" : 0,
      |		"checkItemsChecked" : 0,
      |		"comments" : 0,
      |		"attachments" : 0,
      |		"description" : true,
      |		"due" : null
      |	},
      |	"checkItemStates" : [],
      |	"closed" : ${card.closed},
      |	"dateLastActivity" : "${card.dateLastActivity}",
      |	"desc" : "${card.desc}",
      |	"descData" : null,
      |	"due" : null,
      |	"idBoard" : "${card.idBoard}",
      |	"idChecklists" : ["${card.idChecklists(0)}", "${card.idChecklists(1)}"],
      |	"idList" : "${card.idList}",
      |	"idMembers" : ["${card.idMembers(0)}"],
      |	"idShort" : ${card.idShort},
      |	"idAttachmentCover" : null,
      |	"manualCoverAttachment" : ${card.manualCoverAttachment},
      |	"labels" : [{
      |			"color" : "yellow",
      |			"name" : "yellow label name"
      |		}, {
      |			"color" : "purple",
      |			"name" : "purple label name"
      |		}
      |	],
      |	"name" : "${card.name}",
      |	"pos" : ${card.pos},
      |	"shortUrl" : "https://trello.com/c/uNd3s",
      |	"url" : "https://trello.com/c/uNd3s/78-test-card",
      |	"membersVoted" : []
      |}
    """.stripMargin
}
