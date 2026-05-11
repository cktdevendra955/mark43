package com.mark43.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CertificationDto {
    private String name;

    private String organization;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String credentialId;

    private String certificateUrl;
}
