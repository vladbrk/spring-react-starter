package org.springsandbox.back.service;

import org.springsandbox.back.repo.entity.Contract;

import java.util.List;
import java.util.Optional;


public interface ContractService {

    Iterable<Contract> getAll();
    Optional<Contract> get(Long id);
}
