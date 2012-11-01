package controllers


import play.api._
import play.api.mvc._
import play.api.data._

object Application extends Controller with securesocial.core.SecureSocial{
  

	def index = Action {
  		val blogtitle = "K. Aning's Web Log"
    	Ok(views.html.index(blogtitle, "Your new application is ready."))
  }
  

  // Administration
  def wppadmin = SecuredAction() { implicit request =>
    Ok(views.html.admin(request.user))
  }
}