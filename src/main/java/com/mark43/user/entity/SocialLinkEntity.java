package com.mark43.user.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "social_links")
@Getter
@Setter
public class SocialLinkEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserProfileEntity profile;
    private String platform;
    private String url;
}