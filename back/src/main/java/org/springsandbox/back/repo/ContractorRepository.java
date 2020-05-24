package org.springsandbox.back.repo;

import org.springsandbox.back.repo.dto.Contractor;

import java.util.List;

@Deprecated
public interface ContractorRepository {

    Contractor findOne(Long id);

    List<Contractor> findAll();

    void insert(Contractor contractor);
}
