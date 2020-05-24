package org.springsandbox.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsandbox.back.repo.dto.Contractor;
import org.springsandbox.back.repo.ContractorRepository;
import org.springsandbox.back.service.ContractorService;

@Deprecated
@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    public String message() {
        return "{\"message\": \"Hi, fellows!\"}";
    }

    @Override
    public int countContractor() {
        return contractorRepository.findAll().size();
    }

    @Override
    public void insert(String name) {
        Contractor contractor = new Contractor();
        contractor.setId(1L);
        contractor.setName(name);
        contractorRepository.insert(contractor);
    }
}
