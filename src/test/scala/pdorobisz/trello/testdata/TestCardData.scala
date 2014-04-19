package pdorobisz.trello.testdata

import pdorobisz.trello.data.Card

object TestCardData {

  val card = Card("test card", "this is a test card")

  val json =
    s"""
      {
      |	"id" : "sdf987u3j",
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
      |	"closed" : false,
      |	"dateLastActivity" : "2013-06-21T08:00:21.412Z",
      |	"desc" : "${card.desc}",
      |	"descData" : null,
      |	"due" : null,
      |	"idBoard" : "798dsf37989",
      |	"idChecklists" : [],
      |	"idList" : "6yui9087y",
      |	"idMembers" : [],
      |	"idShort" : 78,
      |	"idAttachmentCover" : null,
      |	"manualCoverAttachment" : false,
      |	"labels" : [{
      |			"color" : "yellow",
      |			"name" : "yellow label name"
      |		}, {
      |			"color" : "purple",
      |			"name" : "purple label name"
      |		}
      |	],
      |	"name" : "${card.name}",
      |	"pos" : 123345,
      |	"shortUrl" : "https://trello.com/c/uNd3s",
      |	"url" : "https://trello.com/c/uNd3s/78-test-card",
      |	"membersVoted" : []
      |}
    """.stripMargin
}
