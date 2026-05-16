package com.mark43.user.dto.certification;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CertificationResponse {

    private String name;

    private String organization;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String credentialId;

    private String certificateUrl;
}
