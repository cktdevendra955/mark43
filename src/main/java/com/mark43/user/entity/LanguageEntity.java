package com.mark43.user.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "languages")
@Getter
@Setter
public class LanguageEntity extends BaseEntity {
    private String name;
}
