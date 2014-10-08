package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * Created by oliver on 08.10.14.
 */
@With(Secure.class)
public class Admin extends Controller
{

    public static void index()
    {
        render();
    }

    @Before
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.fullname);
        }
    }
}
