module spring.sandbox.back.main {
    requires springsandbox.core;
    requires spring.boot.starter.web;
    requires spring.context;
    requires spring.jdbc;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
    requires spring.tx;
    requires spring.beans;
    requires lombok;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires com.fasterxml.jackson.databind;
    requires java.persistence;
    exports org.springsandbox.back.configuration;
    exports org.springsandbox.back.service;
    exports org.springsandbox.back.repo.dto;
    exports org.springsandbox.back.repo.entity;
}