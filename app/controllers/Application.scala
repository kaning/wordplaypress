package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
  	var blogtitle = "K. Aning's Web Log"
    Ok(views.html.index(blogtitle, "Your new application is ready."))
  }

  def wppadmin = Action {
  	Ok(views.html.admin(user))
  }
  
}