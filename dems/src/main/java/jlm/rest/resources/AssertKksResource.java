package jlm.rest.resources;

import jlm.JsonViews;
import jlm.dao.assertkks.AssertKksDao;
import jlm.dao.blogpost.BlogPostDao;
import jlm.entity.AssertKks;
import jlm.entity.BlogPost;
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
@Path("/assertkks")
public class AssertKksResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssertKksDao assertKksDao;

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
        List<AssertKks> allEntries = this.assertKksDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertKks read(@PathParam("id") Long id)
    {
        this.logger.info("read(id)");

        AssertKks assertKks = this.assertKksDao.find(id);
        if (assertKks == null) {
            throw new WebApplicationException(404);
        }
        return assertKks;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AssertKks create(AssertKks assertKks)
    {
        this.logger.info("create(): " + assertKks);

        return this.assertKksDao.save(assertKks);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertKks update(@PathParam("id") Long id, AssertKks assertKks)
    {
        this.logger.info("update(): " +assertKks);

        return this.assertKksDao.save(assertKks);
        //return null;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        this.logger.info("delete(id)");

        this.assertKksDao.delete(id);
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
