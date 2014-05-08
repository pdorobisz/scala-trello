package pdorobisz.trello.internal

import spray.httpx.unmarshalling.Unmarshaller
import spray.http._
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import pdorobisz.trello.data.{TrelloObject, Card}

import MediaTypes._
import com.fasterxml.jackson.datatype.joda.JodaModule

object TrelloJsonProtocol {

  implicit val cardFormat = createUnmarshaller(classOf[Card])

  private val mapper = new ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .registerModule(DefaultScalaModule)
    .registerModule(new JodaModule())

  private def createUnmarshaller[T <: TrelloObject](clazz: Class[T]): Unmarshaller[T] =
    Unmarshaller[T](ContentTypeRange(`application/json`)) {
      case HttpEntity.NonEmpty(contentType, data) => mapper.readValue(data.asString, clazz)
    }
}
