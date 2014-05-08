package pdorobisz.trello.util

import org.joda.time.{DateTimeZone, DateTime}

object DateUtil {
  def currentDate: DateTime = new DateTime(DateTimeZone.forID("UTC"))
}
