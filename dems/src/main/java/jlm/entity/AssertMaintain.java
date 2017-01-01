package jlm.entity;

import jlm.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2016/12/30.
 */
@javax.persistence.Entity
public class AssertMaintain  implements Entity{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String fMaintainCompany;

    @Column
    private String fErialNumber;

    @Column
    private String fKks;

    @Column
    private String fEquipmentName;

    @Column
    private String fEnquipmentMonth;

    @Column
    private String fEquipmentLevel;

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(JsonViews.User.class)
    public String getfMaintainCompany() {
        return fMaintainCompany;
    }

    public void setfMaintainCompany(String fMaintainCompany) {
        this.fMaintainCompany = fMaintainCompany;
    }

    @JsonView(JsonViews.User.class)
    public String getfErialNumber() {
        return fErialNumber;
    }

    public void setfErialNumber(String fErialNumber) {
        this.fErialNumber = fErialNumber;
    }

    @JsonView(JsonViews.User.class)
    public String getfKks() {
        return fKks;
    }

    public void setfKks(String fKks) {
        this.fKks = fKks;
    }

    @JsonView(JsonViews.User.class)
    public String getfEquipmentName() {
        return fEquipmentName;
    }

    public void setfEquipmentName(String fEquipmentName) {
        this.fEquipmentName = fEquipmentName;
    }

    @JsonView(JsonViews.User.class)
    public String getfEnquipmentMonth() {
        return fEnquipmentMonth;
    }

    public void setfEnquipmentMonth(String fEnquipmentMonth) {
        this.fEnquipmentMonth = fEnquipmentMonth;
    }

    @JsonView(JsonViews.User.class)
    public String getfEquipmentLevel() {
        return fEquipmentLevel;
    }

    public void setfEquipmentLevel(String fEquipmentLevel) {
        this.fEquipmentLevel = fEquipmentLevel;
    }

    public AssertMaintain() {
    }

    public AssertMaintain(String fMaintainCompany, String fErialNumber, String fKks, String fEquipmentName, String fEnquipmentMonth, String fEquipmentLevel) {
        this.fMaintainCompany = fMaintainCompany;
        this.fErialNumber = fErialNumber;
        this.fKks = fKks;
        this.fEquipmentName = fEquipmentName;
        this.fEnquipmentMonth = fEnquipmentMonth;
        this.fEquipmentLevel = fEquipmentLevel;
    }

    @Override
    public String toString() {
        return "AssertMaintain{" +
                "id=" + id +
                ", fMaintainCompany='" + fMaintainCompany + '\'' +
                ", fErialNumber='" + fErialNumber + '\'' +
                ", fKks='" + fKks + '\'' +
                ", fEquipmentName='" + fEquipmentName + '\'' +
                ", fEnquipmentMonth='" + fEnquipmentMonth + '\'' +
                ", fEquipmentLevel='" + fEquipmentLevel + '\'' +
                '}';
    }
}
