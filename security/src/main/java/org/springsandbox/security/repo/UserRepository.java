package org.springsandbox.security.repo;

import org.springsandbox.security.repo.dto.User;

public interface UserRepository {

    User findByUsername(String username);
}
