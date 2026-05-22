package com.mark43.recruiterdashboard.company.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class CompanyEntity extends BaseEntity {
    private String name;
    private String logo;
    private String website;
    private String industry;
    private String about;
    private String companySize;
    private Integer foundedYear;
    private String email;
    private String phone;
    private String country;
    private String state;
    private String city;
    private String pincode;
    private String address;
    private Boolean verified = false;
    private Boolean active = true;
}