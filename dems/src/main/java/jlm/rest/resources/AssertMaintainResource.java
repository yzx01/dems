package jlm.rest.resources;

import jlm.JsonViews;
import jlm.dao.assertmain.AssertMaintainDao;
import jlm.entity.AssertMaintain;
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
 * Created by Administrator on 2016/12/30.
 */
@Component
@Path("/assertmains")
public class AssertMaintainResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssertMaintainDao assertMaintainDao;

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
        List<AssertMaintain> allEntries = this.assertMaintainDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertMaintain read(@PathParam("id") Long id)
    {
        this.logger.info("read(id)");

        AssertMaintain assertMaintain = this.assertMaintainDao.find(id);
        if (assertMaintain == null) {
            throw new WebApplicationException(404);
        }
        return assertMaintain;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AssertMaintain create(AssertMaintain assertMaintain)
    {
        this.logger.info("create(): " + assertMaintain);

        return this.assertMaintainDao.save(assertMaintain);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public AssertMaintain update(@PathParam("id") Long id, AssertMaintain assertMaintain)
    {
        this.logger.info("update(): " + assertMaintain);

        return this.assertMaintainDao.save(assertMaintain);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        this.logger.info("delete(id)");

        this.assertMaintainDao.delete(id);
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
