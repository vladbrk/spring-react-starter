package org.springsandbox.security.repo.entity;

import lombok.Data;
import org.springsandbox.core.repo.entity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(schema = "security", name = "user")
public class User extends AbstractEntity {

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<GrantedRole> roles;
}
