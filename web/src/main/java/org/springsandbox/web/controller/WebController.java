package org.springsandbox.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springsandbox.back.repo.entity.Contract;
import org.springsandbox.back.service.ContractService;
import org.springsandbox.back.service.ContractorService;
import org.springsandbox.security.repo.entity.User;
import org.springsandbox.security.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin
@RestController
public class WebController {

    @Deprecated
    private String BR = "<br/>";

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private UserService userService;

    @Deprecated
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "*"})
    @GetMapping("/api/contractors")
    public String index() {
        StringBuilder sb = new StringBuilder();
        contractService.getAll().forEach(c -> {
            sb.append(c.getTitle()).append(BR);
        });
        //contractorService.insert("Pepsi");
        return "Count contractor " + contractorService.countContractor() + BR + sb.toString();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "*"})
    @GetMapping("/api/contracts")
    public List<Contract> contracts() {
        return StreamSupport.stream(contractService.getAll().spliterator(), false).collect(Collectors.toList());
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "*"})
    @GetMapping("/api/contract/{id}")
    public ResponseEntity contracts(@PathVariable Long id) {
        Optional<Contract> contract = contractService.get(id);
        if (contract.isEmpty()) {
            return new ResponseEntity<>("CONTRACT_NOT_FOUND",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(contract.get(), HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "*"})
    @GetMapping("/api/users")
    public List<User> users() {
        return userService.getUsers();
    }

}
