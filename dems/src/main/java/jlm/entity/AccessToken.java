package jlm.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author
 */
@javax.persistence.Entity
public class AccessToken implements Entity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fToken;

    @ManyToOne
    private User fUser;

    @Column
    private Date fExpiry;

    protected AccessToken()
    {
        /* Reflection instantiation */
    }



    public AccessToken(User fUser, String fToken)
    {
        this.fUser = fUser;
        this.fToken = fToken;
    }

    public AccessToken(User fUser, String fToken, Date fExpiry)
    {
        this(fUser, fToken);
        this.fExpiry = fExpiry;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfToken() {
        return fToken;
    }

    public void setfToken(String fToken) {
        this.fToken = fToken;
    }

    public User getfUser() {
        return fUser;
    }

    public void setfUser(User fUser) {
        this.fUser = fUser;
    }

    public Date getfExpiry() {
        return fExpiry;
    }

    public void setfExpiry(Date fExpiry) {
        this.fExpiry = fExpiry;
    }

    public boolean isExpired()
    {
        if (null == this.fExpiry) {
            return false;
        }

        return this.fExpiry.getTime() > System.currentTimeMillis();
    }
}
