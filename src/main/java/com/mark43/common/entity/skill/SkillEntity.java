package com.mark43.common.entity.skill;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class SkillEntity extends BaseEntity {

    private String name;

    private String slug;

    private String icon;

    private String status;
}