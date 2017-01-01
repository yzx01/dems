package jlm.dao;

import jlm.dao.blogpost.BlogPostDao;
import jlm.dao.user.UserDao;
import jlm.entity.BlogPost;
import jlm.entity.Role;
import jlm.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

/**
 * Initialize the database with some test entries.
 *
 * @author
 */
public class DataBaseInitializer
{
    private BlogPostDao blogPostDao;

    private UserDao userDao;

    private PasswordEncoder passwordEncoder;

    protected DataBaseInitializer()
    {
        /* Default constructor for reflection instantiation */
    }

    public DataBaseInitializer(UserDao userDao, BlogPostDao blogPostDao, PasswordEncoder passwordEncoder)
    {
        this.userDao = userDao;
        this.blogPostDao = blogPostDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void initDataBase()
    {
        User userUser = new User("user", this.passwordEncoder.encode("user"));
        userUser.addRole(Role.USER);
        this.userDao.save(userUser);

        User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
        adminUser.addRole(Role.USER);
        adminUser.addRole(Role.ADMIN);
        this.userDao.save(adminUser);

        long timestamp = System.currentTimeMillis() - (1000 * 60 * 60 * 24);
        for (int i = 0; i < 10; i++) {
            BlogPost blogPost = new BlogPost();
            blogPost.setfContent("This is example content " + i);
            blogPost.setfDate(new Date(timestamp));
            this.blogPostDao.save(blogPost);
            timestamp += 1000 * 60 * 60;
        }
    }
}
