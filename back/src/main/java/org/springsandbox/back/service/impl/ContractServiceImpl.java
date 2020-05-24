package org.springsandbox.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsandbox.back.repo.JpaContractRepository;
import org.springsandbox.back.repo.entity.Contract;
import org.springsandbox.back.service.ContractService;

import javax.persistence.ConstructorResult;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private JpaContractRepository contractRepository;

    @Override
    public Iterable<Contract> getAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> get(Long id) {
        return contractRepository.findById(id);
    }

}
