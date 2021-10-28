import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")


public class test {
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String hello(){
        return "hello";
    }
}
