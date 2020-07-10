package calculator.business.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import calculator.model.user.User;
import calculator.model.user.UserApi;

@Path("/user")
public class WSUserREST
{

    @EJB
    private UserApi userApi;

    @GET
    @Path("/users")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<User> getUser()
    {
        return userApi.findAll();
    }

}
