package jlm.entity;

import jlm.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/31.
 */
@javax.persistence.Entity
public class ComponentManage implements Entity {

    @Id
    @GeneratedValue
    private Long id;
    private Date fInputStoreDate;
    private String fInputStoreId;
    private Integer fQuantity;
    private String fStoreId;
    private Date fetchDate;
    private String fetcherId;
    private String fetcher;
    private Integer fRemainQuantity;
    private String fRemarks;

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(JsonViews.User.class)
    public Date getfInputStoreDate() {
        return fInputStoreDate;
    }

    public void setfInputStoreDate(Date fInputStoreDate) {
        this.fInputStoreDate = fInputStoreDate;
    }

    @JsonView(JsonViews.User.class)
    public String getfInputStoreId() {
        return fInputStoreId;
    }

    public void setfInputStoreId(String fInputStoreId) {
        this.fInputStoreId = fInputStoreId;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfQuantity() {
        return fQuantity;
    }

    public void setfQuantity(Integer fQuantity) {
        this.fQuantity = fQuantity;
    }

    @JsonView(JsonViews.User.class)
    public String getfStoreId() {
        return fStoreId;
    }

    public void setfStoreId(String fStoreId) {
        this.fStoreId = fStoreId;
    }

    @JsonView(JsonViews.User.class)
    public Date getFetchDate() {
        return fetchDate;
    }

    public void setFetchDate(Date fetchDate) {
        this.fetchDate = fetchDate;
    }

    @JsonView(JsonViews.User.class)
    public String getFetcherId() {
        return fetcherId;
    }

    public void setFetcherId(String fetcherId) {
        this.fetcherId = fetcherId;
    }

    @JsonView(JsonViews.User.class)
    public String getFetcher() {
        return fetcher;
    }

    public void setFetcher(String fetcher) {
        this.fetcher = fetcher;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfRemainQuantity() {
        return fRemainQuantity;
    }

    public void setfRemainQuantity(Integer fRemainQuantity) {
        this.fRemainQuantity = fRemainQuantity;
    }

    @JsonView(JsonViews.User.class)
    public String getfRemarks() {
        return fRemarks;
    }

    public void setfRemarks(String fRemarks) {
        this.fRemarks = fRemarks;
    }

    public ComponentManage() {
    }

    public ComponentManage(Date fInputStoreDate, String fInputStoreId, Integer fQuantity, String fStoreId, Date fetchDate, String fetcherId, String fetcher, Integer fRemainQuantity, String fRemarks) {
        this.fInputStoreDate = fInputStoreDate;
        this.fInputStoreId = fInputStoreId;
        this.fQuantity = fQuantity;
        this.fStoreId = fStoreId;
        this.fetchDate = fetchDate;
        this.fetcherId = fetcherId;
        this.fetcher = fetcher;
        this.fRemainQuantity = fRemainQuantity;
        this.fRemarks = fRemarks;
    }

    @Override
    public String toString() {
        return "ComponentManage{" +
                "id=" + id +
                ", fInputStoreDate=" + fInputStoreDate +
                ", fInputStoreId='" + fInputStoreId + '\'' +
                ", fQuantity=" + fQuantity +
                ", fStoreId='" + fStoreId + '\'' +
                ", fetchDate=" + fetchDate +
                ", fetcherId='" + fetcherId + '\'' +
                ", fetcher='" + fetcher + '\'' +
                ", fRemainQuantity=" + fRemainQuantity +
                ", fRemarks='" + fRemarks + '\'' +
                '}';
    }
}
