package controllers

import org.joda.time.LocalDate
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.core.routing.Route


/**
  * Created by andrew on 30/11/17.
  */
class AllBooksControllerSpec extends PlaySpec with GuiceOneAppPerTest{
  "calling getAllBooks" should {
    "return all books" in {
      val controller = new AllBooksController
      val response = controller.getAllBooks().apply(FakeRequest())
      status(response) mustBe 200

      val json = contentAsJson(response)
      (json \ "title").as[String] mustBe "It"
      (json \ "author").as[String] mustBe "Stephen King"

    }
    "calling getAllBooks URL" should {
      "return all books" in {
        val request = FakeRequest("GET", "/get-all-books").withHeaders("host"->"localhost")
        val result=route(app,request).get
        val response = route(app, request).get
        status(response) mustBe 200
        contentType(response) mustBe Some("application/json")
        val json = contentAsJson(response)
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa" +json )
        (json \"books"\"title").as[String] mustBe "It"
        (json \"books"\"author").as[String] mustBe "Stephen King"
        (json \"books"\"title").as[String] mustBe "Picnic at Hanging Rock"
        (json \"books"\"author").as[String] mustBe "Joan Lindsay"

      }
    }
  }
}
