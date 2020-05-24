package org.springsandbox.back.repo;


import org.springframework.data.repository.CrudRepository;
import org.springsandbox.back.repo.entity.Contract;

import java.util.List;

public interface JpaContractRepository extends CrudRepository<Contract, Long> {

    List<Contract> findByTitle(String title);
}
