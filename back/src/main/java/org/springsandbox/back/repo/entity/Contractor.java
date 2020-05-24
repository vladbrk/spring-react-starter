package org.springsandbox.back.repo.entity;

import lombok.Data;
import org.springsandbox.core.repo.entity.AbstractEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Deprecated
@Data
@Entity
@Table(schema = "ministry", name = "contractor")
public class Contractor extends AbstractEntity {

    @Column
    private String name;
}
