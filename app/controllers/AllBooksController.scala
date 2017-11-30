package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import models.{Book, Books}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by andrew on 30/11/17.
  */
@Singleton
class AllBooksController @Inject() extends Controller {

  def getAllBooks()=Action{
    implicit request =>
      val book1=Book("It","Stephen King")
      val book2=Book("Picnic at Hanging Rock","Joan Lindsay")
      val books=List(book1,book2)
      Ok(Json.toJson(Books(books)))
  }

}
