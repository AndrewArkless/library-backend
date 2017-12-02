package controllers

import com.google.inject.Inject
import models.{DVD, DVDS}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by andrew on 02/12/17.
  */
class AllDVDSController @Inject() extends Controller {

  def getAllDVDS()=Action{
    implicit request =>
      val dvds=DVDS(List[DVD]
        (DVD("Alien","Ridley Scott"),
         DVD("The Thing","John Carpenter")))
      Ok(Json.toJson(dvds))
  }

}
