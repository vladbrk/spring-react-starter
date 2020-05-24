package org.springsandbox.back.repo.entity;

import lombok.Data;
import org.springsandbox.core.repo.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "contract", name = "contract")
public class Contract extends AbstractEntity {

    @Column
    private String title;

    @Column
    private Date startDate;

    @Column
    private Date closureDate;

    @Column
    private Long cost;
}
