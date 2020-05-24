package org.springsandbox.security.repo.entity;

import org.springsandbox.core.repo.entity.AbstractEntity;
import org.springsandbox.security.repo.dto.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "security", name = "role")
public class GrantedRole extends AbstractEntity {

    @Column
    private Integer role;

    public Role getRole() {
        return Role.find(role);
    }

    public void setRole(Role role) {
        this.role = role.getId();
    }
}
