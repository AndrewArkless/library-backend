package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

/**
  * Created by andrew on 02/12/17.
  */
class AllDVDSControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "Calling AllDVDSController" should {
   "Return a list of dvds as Json" in {
     val controller = new AllDVDSController
     val response = controller.getAllDVDS.apply(FakeRequest())
     status(response) mustBe OK
     contentType(response) mustBe Some("application/json")
     val json =contentAsJson(response)
     (json \"dvds"\0\"title").as[String] mustBe "Alien"
     (json \"dvds"\0\"director").as[String] mustBe "Ridley Scott"
     (json \"dvds"\1\"title").as[String] mustBe "The Thing"
     (json \"dvds"\1\"director").as[String] mustBe "John Carpenter"
   }
 }

  "Calling AllDVDSController url " should {
    "Return a list of dvds as Json" in {
      val request=FakeRequest("GET","/get-all-dvds").withHeaders("host"->"localhost")
      val response = route(app,request).get
      status(response) mustBe OK
      contentType(response) mustBe Some("application/json")
      val json =contentAsJson(response)
      (json \"dvds"\0\"title").as[String] mustBe "Alien"
      (json \"dvds"\0\"director").as[String] mustBe "Ridley Scott"
      (json \"dvds"\1\"title").as[String] mustBe "The Thing"
      (json \"dvds"\1\"director").as[String] mustBe "John Carpenter"
    }
  }
}
