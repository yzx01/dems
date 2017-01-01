package jlm.rest.resources;

import jlm.JsonViews;
import jlm.dao.blogpost.BlogPostDao;
import jlm.dao.componentmanage.ComponentManageDao;
import jlm.entity.BlogPost;
import jlm.entity.ComponentManage;
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
@Path("/componentmanages")
public class ComponentManageResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ComponentManageDao componentManageDao;

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
        List<ComponentManage> allEntries = this.componentManageDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public ComponentManage read(@PathParam("id") Long id)
    {
        this.logger.info("read(id)");

        ComponentManage componentManage = this.componentManageDao.find(id);
        if (componentManage == null) {
            throw new WebApplicationException(404);
        }
        return componentManage;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ComponentManage create(ComponentManage componentManage)
    {
        this.logger.info("create(): " + componentManage);

        return this.componentManageDao.save(componentManage);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public ComponentManage update(@PathParam("id") Long id, ComponentManage componentManage)
    {
        this.logger.info("update(): " +componentManage);

        return this.componentManageDao.save(componentManage);
        //return null;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        this.logger.info("delete(id)");

        this.componentManageDao.delete(id);
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
