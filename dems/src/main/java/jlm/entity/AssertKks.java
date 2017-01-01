package jlm.entity;

import jlm.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/31.
 */
@javax.persistence.Entity
public class AssertKks implements Entity{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String fKks;

    @Column
    private String fEquipmentName;

    @Column
    private String fOriginalCode;

    @Column
    private String fSpecification;

    @Column
    private String fDepartment;

    @Column
    private String fProfession;

    @Column
    private String fClasses;

    @Column
    private String fParentKks;

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getfOriginalCode() {
        return fOriginalCode;
    }

    public void setfOriginalCode(String fOriginalCode) {
        this.fOriginalCode = fOriginalCode;
    }

    @JsonView(JsonViews.User.class)
    public String getfSpecification() {
        return fSpecification;
    }

    public void setfSpecification(String fSpecification) {
        this.fSpecification = fSpecification;
    }

    @JsonView(JsonViews.User.class)
    public String getfDepartment() {
        return fDepartment;
    }

    public void setfDepartment(String fDepartment) {
        this.fDepartment = fDepartment;
    }

    @JsonView(JsonViews.User.class)
    public String getfProfession() {
        return fProfession;
    }

    public void setfProfession(String fProfession) {
        this.fProfession = fProfession;
    }

    @JsonView(JsonViews.User.class)
    public String getfClasses() {
        return fClasses;
    }

    public void setfClasses(String fClasses) {
        this.fClasses = fClasses;
    }

    @JsonView(JsonViews.User.class)
    public String getfParentKks() {
        return fParentKks;
    }

    public void setfParentKks(String fParentKks) {
        this.fParentKks = fParentKks;
    }

    public AssertKks() {
    }

    public AssertKks(String fKks, String fEquipmentName, String fOriginalCode, String fSpecification, String fDepartment, String fProfession, String fClasses, String fParentKks) {
        this.fKks = fKks;
        this.fEquipmentName = fEquipmentName;
        this.fOriginalCode = fOriginalCode;
        this.fSpecification = fSpecification;
        this.fDepartment = fDepartment;
        this.fProfession = fProfession;
        this.fClasses = fClasses;
        this.fParentKks = fParentKks;
    }

    @Override
    public String toString() {
        return "AssertKks{" +
                "id=" + id +
                ", fKks='" + fKks + '\'' +
                ", fEquipmentName='" + fEquipmentName + '\'' +
                ", fOriginalCode='" + fOriginalCode + '\'' +
                ", fSpecification='" + fSpecification + '\'' +
                ", fDepartment='" + fDepartment + '\'' +
                ", fProfession='" + fProfession + '\'' +
                ", fClasses='" + fClasses + '\'' +
                ", fParentKks='" + fParentKks + '\'' +
                '}';
    }
}
