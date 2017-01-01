package jlm.entity;

import jlm.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/31.
 */
@javax.persistence.Entity
public class AssertMonthOperation implements Entity{

    @Id
    @GeneratedValue
    private Long id;

    private String fMonSerialNumber;

    private Date fOperationDate;

    private String fUseAddress;

    private String fCompleteLoad;

    private Integer fMovementHour;

    private Integer fParkingHour;

    private String fMaintainCircs;

    private Integer fUserRate;

    private Integer fImposeRate;

    private String fOperater;

    private String fChargeDepartment;

    private String fKks;

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(JsonViews.User.class)
    public String getfMonSerialNumber() {
        return fMonSerialNumber;
    }

    public void setfMonSerialNumber(String fMonSerialNumber) {
        this.fMonSerialNumber = fMonSerialNumber;
    }

    @JsonView(JsonViews.User.class)
    public Date getfOperationDate() {
        return fOperationDate;
    }

    public void setfOperationDate(Date fOperationDate) {
        this.fOperationDate = fOperationDate;
    }

    @JsonView(JsonViews.User.class)
    public String getfUseAddress() {
        return fUseAddress;
    }

    public void setfUseAddress(String fUseAddress) {
        this.fUseAddress = fUseAddress;
    }

    @JsonView(JsonViews.User.class)
    public String getfCompleteLoad() {
        return fCompleteLoad;
    }

    public void setfCompleteLoad(String fCompleteLoad) {
        this.fCompleteLoad = fCompleteLoad;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfMovementHour() {
        return fMovementHour;
    }

    public void setfMovementHour(Integer fMovementHour) {
        this.fMovementHour = fMovementHour;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfParkingHour() {
        return fParkingHour;
    }

    public void setfParkingHour(Integer fParkingHour) {
        this.fParkingHour = fParkingHour;
    }

    @JsonView(JsonViews.User.class)
    public String getfMaintainCircs() {
        return fMaintainCircs;
    }

    public void setfMaintainCircs(String fMaintainCircs) {
        this.fMaintainCircs = fMaintainCircs;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfUserRate() {
        return fUserRate;
    }

    public void setfUserRate(Integer fUserRate) {
        this.fUserRate = fUserRate;
    }

    @JsonView(JsonViews.User.class)
    public Integer getfImposeRate() {
        return fImposeRate;
    }

    public void setfImposeRate(Integer fImposeRate) {
        this.fImposeRate = fImposeRate;
    }

    @JsonView(JsonViews.User.class)
    public String getfOperater() {
        return fOperater;
    }

    public void setfOperater(String fOperater) {
        this.fOperater = fOperater;
    }

    @JsonView(JsonViews.User.class)
    public String getfChargeDepartment() {
        return fChargeDepartment;
    }

    public void setfChargeDepartment(String fChargeDepartment) {
        this.fChargeDepartment = fChargeDepartment;
    }

    @JsonView(JsonViews.User.class)
    public String getfKks() {
        return fKks;
    }

    public void setfKks(String fKks) {
        this.fKks = fKks;
    }

    public AssertMonthOperation() {
    }

    public AssertMonthOperation(String fMonSerialNumber, Date fOperationDate, String fUseAddress, String fCompleteLoad, Integer fMovementHour, Integer fParkingHour, String fMaintainCircs, Integer fUserRate, Integer fImposeRate, String fOperater, String fChargeDepartment, String fKks) {
        this.fMonSerialNumber = fMonSerialNumber;
        this.fOperationDate = fOperationDate;
        this.fUseAddress = fUseAddress;
        this.fCompleteLoad = fCompleteLoad;
        this.fMovementHour = fMovementHour;
        this.fParkingHour = fParkingHour;
        this.fMaintainCircs = fMaintainCircs;
        this.fUserRate = fUserRate;
        this.fImposeRate = fImposeRate;
        this.fOperater = fOperater;
        this.fChargeDepartment = fChargeDepartment;
        this.fKks = fKks;
    }

    @Override
    public String toString() {
        return "AssertMonthOperation{" +
                "id=" + id +
                ", fMonSerialNumber='" + fMonSerialNumber + '\'' +
                ", fOperationDate=" + fOperationDate +
                ", fUseAddress='" + fUseAddress + '\'' +
                ", fCompleteLoad='" + fCompleteLoad + '\'' +
                ", fMovementHour=" + fMovementHour +
                ", fParkingHour=" + fParkingHour +
                ", fMaintainCircs='" + fMaintainCircs + '\'' +
                ", fUserRate=" + fUserRate +
                ", fImposeRate=" + fImposeRate +
                ", fOperater='" + fOperater + '\'' +
                ", fChargeDepartment='" + fChargeDepartment + '\'' +
                ", fKks='" + fKks + '\'' +
                '}';
    }
}
