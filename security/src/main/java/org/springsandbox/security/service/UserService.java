package org.springsandbox.security.service;

import org.springsandbox.security.repo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
}
