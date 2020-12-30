package com.nikka.powerapp.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "complains")
public class Complain {

    private Long id;
    private String name;
    private String mobile;
    private String address;
    private String problemDescription;
    private String warrantyStatement;
    private String registrationDateTime;
    private String onSiteArrivalDateTime;
    private String requiredParts;
    private String suppliedParts;
    private String returnedParts;
    private String resolutionDateTime;
    private String engineer;
    private String remarks;



    public Complain() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "problem_description")
    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    @Column(name = "warranty_statement")
    public String getWarrantyStatement() {
        return warrantyStatement;
    }

    public void setWarrantyStatement(String warrantyStatement) {
        this.warrantyStatement = warrantyStatement;
    }

    @Column(name = "registration_date_time")
    public String getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(String registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    @Column(name = "onsite_arrival_date_time")
    public String getOnSiteArrivalDateTime() {
        return onSiteArrivalDateTime;
    }

    public void setOnSiteArrivalDateTime(String onSiteArrivalDateTime) {
        this.onSiteArrivalDateTime = onSiteArrivalDateTime;
    }

    @Column(name = "required_parts")
    public String getRequiredParts() {
        return requiredParts;
    }

    public void setRequiredParts(String requiredParts) {
        this.requiredParts = requiredParts;
    }

    @Column(name = "supplied_parts")
    public String getSuppliedParts() {
        return suppliedParts;
    }

    public void setSuppliedParts(String suppliedParts) {
        this.suppliedParts = suppliedParts;
    }

    @Column(name = "returned_parts")
    public String getReturnedParts() {
        return returnedParts;
    }

    public void setReturnedParts(String returnedParts) {
        this.returnedParts = returnedParts;
    }

    @Column(name = "resolution_date_time")
    public String getResolutionDateTime() {
        return resolutionDateTime;
    }

    public void setResolutionDateTime(String resolutionDateTime) {
        this.resolutionDateTime = resolutionDateTime;
    }

    @Column(name = "engineer")
    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
