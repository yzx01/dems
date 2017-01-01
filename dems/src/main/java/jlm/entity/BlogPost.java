package jlm.entity;

import jlm.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * JPA Annotated Pojo that represents a blog post.
 *
 * @author
 */
@javax.persistence.Entity
public class BlogPost implements Entity
{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Date fDate;

    @Column
    private String fContent;

    public BlogPost()
    {
        this.fDate = new Date();
    }

    @JsonView(JsonViews.Admin.class)
    public Long getId()
    {
        return this.id;
    }



    @JsonView(JsonViews.User.class)
    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate)
    {
        this.fDate = fDate;
    }

    @JsonView(JsonViews.User.class)
    public String getfContent()
    {
        return this.fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    @Override
    public String toString()
    {
        return String.format("BlogPost[%d, %s]", this.id, this.fContent);
    }
}
