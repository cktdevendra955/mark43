package com.mark43.recruiterdashboard.company.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CompanyDto {

    private UUID uniqueId;
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
    private Boolean verified;
    private Boolean active;
}