package jlm.rest.resources;

import jlm.JsonViews;
import jlm.dao.assertchanging.AssertChangingDao;
import jlm.dao.assertkks.AssertKksDao;
import jlm.entity.AssertChanging;
import jlm.entity.AssertKks;
import jlm.entity.Role;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
@Component
@Path("assertchangings")
public class AssertChangingResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssertChangingDao assertChangingDao;

    @Autowired
    private ObjectMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException
    {
        this.logger.info("list()");

        ObjectWriter viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
//        if (this.isAdmin()) {
//            viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
//        } else {
//            viewWriter = this.mapper.writerWithView(JsonViews.User.class);
//        }
        List<AssertChanging> allEntries = this.assertChangingDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertChanging read(@PathParam("id") Long id)
    {
        this.logger.info("read(id)");

        AssertChanging assertChanging = this.assertChangingDao.find(id);
        if (assertChanging == null) {
            throw new WebApplicationException(404);
        }
        return assertChanging;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AssertChanging create(AssertChanging assertChanging)
    {
        this.logger.info("create(): " + assertChanging);

        return this.assertChangingDao.save(assertChanging);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertChanging update(@PathParam("id") Long id, AssertChanging assertChanging)
    {
        this.logger.info("update(): " +assertChanging);

        return this.assertChangingDao.save(assertChanging);
        //return null;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        this.logger.info("delete(id)");

        this.assertChangingDao.delete(id);
    }

    private boolean isAdmin()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if ((principal instanceof String) && ((String) principal).equals("anonymousUser")) {
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;

        return userDetails.getAuthorities().contains(Role.ADMIN);
    }
}
