module spring.sandbox.security.main {
    requires springsandbox.core;

    requires lombok;
    requires java.sql;
    requires java.persistence;
    requires spring.beans;
    requires spring.context;
    requires spring.jdbc;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.security.core;
    requires spring.security.web;
    requires spring.security.config;
    requires spring.boot.autoconfigure;

    requires com.fasterxml.jackson.databind;

    exports org.springsandbox.security.configuration;
    exports org.springsandbox.security.service;
    exports org.springsandbox.security.repo.entity;

}