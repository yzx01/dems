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
public class AssertChanging implements Entity {

    @Id
    @GeneratedValue
    private Long id;

    private String fRedoPart;

    private String fCharacter;

    private String fName;

    private String fStandard;

    private String fDepartmentPrincipal;

    private Date fTime;

    private String fRedoTechStatus;

    private String fArtificer;

    private String fCheckIdea;

    private String fCheckPerson;

    private String fOperater;

    private String fAmendUnit;

    private String fAmendCheckPerson;

    private String fChargeDepartmentPrincipal;

    private String fKks;

    private String fRemarks;

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(JsonViews.User.class)
    public String getfRedoPart() {
        return fRedoPart;
    }

    public void setfRedoPart(String fRedoPart) {
        this.fRedoPart = fRedoPart;
    }

    @JsonView(JsonViews.User.class)
    public String getfCharacter() {
        return fCharacter;
    }

    public void setfCharacter(String fCharacter) {
        this.fCharacter = fCharacter;
    }

    @JsonView(JsonViews.User.class)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @JsonView(JsonViews.User.class)
    public String getfStandard() {
        return fStandard;
    }

    public void setfStandard(String fStandard) {
        this.fStandard = fStandard;
    }

    @JsonView(JsonViews.User.class)
    public String getfDepartmentPrincipal() {
        return fDepartmentPrincipal;
    }

    public void setfDepartmentPrincipal(String fDepartmentPrincipal) {
        this.fDepartmentPrincipal = fDepartmentPrincipal;
    }

    @JsonView(JsonViews.User.class)
    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    @JsonView(JsonViews.User.class)
    public String getfRedoTechStatus() {
        return fRedoTechStatus;
    }

    public void setfRedoTechStatus(String fRedoTechStatus) {
        this.fRedoTechStatus = fRedoTechStatus;
    }

    @JsonView(JsonViews.User.class)
    public String getfArtificer() {
        return fArtificer;
    }

    public void setfArtificer(String fArtificer) {
        this.fArtificer = fArtificer;
    }

    @JsonView(JsonViews.User.class)
    public String getfCheckIdea() {
        return fCheckIdea;
    }

    public void setfCheckIdea(String fCheckIdea) {
        this.fCheckIdea = fCheckIdea;
    }

    @JsonView(JsonViews.User.class)
    public String getfCheckPerson() {
        return fCheckPerson;
    }

    public void setfCheckPerson(String fCheckPerson) {
        this.fCheckPerson = fCheckPerson;
    }

    @JsonView(JsonViews.User.class)
    public String getfOperater() {
        return fOperater;
    }

    public void setfOperater(String fOperater) {
        this.fOperater = fOperater;
    }

    @JsonView(JsonViews.User.class)
    public String getfAmendUnit() {
        return fAmendUnit;
    }

    public void setfAmendUnit(String fAmendUnit) {
        this.fAmendUnit = fAmendUnit;
    }

    @JsonView(JsonViews.User.class)
    public String getfAmendCheckPerson() {
        return fAmendCheckPerson;
    }

    public void setfAmendCheckPerson(String fAmendCheckPerson) {
        this.fAmendCheckPerson = fAmendCheckPerson;
    }

    @JsonView(JsonViews.User.class)
    public String getfChargeDepartmentPrincipal() {
        return fChargeDepartmentPrincipal;
    }

    public void setfChargeDepartmentPrincipal(String fChargeDepartmentPrincipal) {
        this.fChargeDepartmentPrincipal = fChargeDepartmentPrincipal;
    }

    @JsonView(JsonViews.User.class)
    public String getfKks() {
        return fKks;
    }

    public void setfKks(String fKks) {
        this.fKks = fKks;
    }

    @JsonView(JsonViews.User.class)
    public String getfRemarks() {
        return fRemarks;
    }

    public void setfRemarks(String fRemarks) {
        this.fRemarks = fRemarks;
    }

    public AssertChanging() {
    }

    public AssertChanging(String fRedoPart, String fCharacter, String fName, String fStandard, String fDepartmentPrincipal, Date fTime, String fRedoTechStatus, String fArtificer, String fCheckIdea, String fCheckPerson, String fOperater, String fAmendUnit, String fAmendCheckPerson, String fChargeDepartmentPrincipal, String fKks, String fRemarks) {
        this.fRedoPart = fRedoPart;
        this.fCharacter = fCharacter;
        this.fName = fName;
        this.fStandard = fStandard;
        this.fDepartmentPrincipal = fDepartmentPrincipal;
        this.fTime = fTime;
        this.fRedoTechStatus = fRedoTechStatus;
        this.fArtificer = fArtificer;
        this.fCheckIdea = fCheckIdea;
        this.fCheckPerson = fCheckPerson;
        this.fOperater = fOperater;
        this.fAmendUnit = fAmendUnit;
        this.fAmendCheckPerson = fAmendCheckPerson;
        this.fChargeDepartmentPrincipal = fChargeDepartmentPrincipal;
        this.fKks = fKks;
        this.fRemarks = fRemarks;
    }

    @Override
    public String toString() {
        return "AssertChanging{" +
                "id=" + id +
                ", fRedoPart='" + fRedoPart + '\'' +
                ", fCharacter='" + fCharacter + '\'' +
                ", fName='" + fName + '\'' +
                ", fStandard='" + fStandard + '\'' +
                ", fDepartmentPrincipal='" + fDepartmentPrincipal + '\'' +
                ", fTime=" + fTime +
                ", fRedoTechStatus='" + fRedoTechStatus + '\'' +
                ", fArtificer='" + fArtificer + '\'' +
                ", fCheckIdea='" + fCheckIdea + '\'' +
                ", fCheckPerson='" + fCheckPerson + '\'' +
                ", fOperater='" + fOperater + '\'' +
                ", fAmendUnit='" + fAmendUnit + '\'' +
                ", fAmendCheckPerson='" + fAmendCheckPerson + '\'' +
                ", fChargeDepartmentPrincipal='" + fChargeDepartmentPrincipal + '\'' +
                ", fKks='" + fKks + '\'' +
                ", fRemarks='" + fRemarks + '\'' +
                '}';
    }
}
