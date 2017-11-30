package models

import play.api.libs.json.{Format, Json}

/**
  * Created by andrew on 30/11/17.
  */

case class Books(books:List[Book])

case class Book(title:String,author:String)

object Book {
  implicit val formats: Format[Book] = Json.format[Book]
}
object Books {
  implicit val formats: Format[Books]=Json.format[Books]
}