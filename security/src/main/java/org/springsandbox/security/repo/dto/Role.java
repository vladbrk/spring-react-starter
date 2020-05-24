package org.springsandbox.security.repo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springsandbox.security.repo.serializer.RoleDeserializer;
import org.springsandbox.security.repo.serializer.RoleSerializer;


@JsonSerialize(using = RoleSerializer.class)
@JsonDeserialize(using = RoleDeserializer.class)
public enum Role {
    ROLE_ADMIN(0, "Администратор"),
    ROLE_USER(1, "Пользователь");

    private int id;
    private String value;

    Role(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static Role find(int id) {
        for(Role r: values()) {
            if (id == r.id) {
                return r;
            }
        }
        return null;
    }

}
