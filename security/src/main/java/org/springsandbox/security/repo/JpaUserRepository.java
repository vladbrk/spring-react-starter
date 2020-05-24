package org.springsandbox.security.repo;

import org.springframework.data.repository.CrudRepository;
import org.springsandbox.security.repo.entity.User;

public interface JpaUserRepository extends CrudRepository<User, Long> {
}
