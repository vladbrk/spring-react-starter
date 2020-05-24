module spring.sandbox.web.main {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;
    requires spring.webmvc;
    requires spring.boot.starter.thymeleaf;
    requires thymeleaf;
    requires thymeleaf.spring5;
    requires spring.beans;
    requires spring.context;

    requires org.postgresql.jdbc;
    requires spring.data.commons;
    requires lombok;
    requires java.sql;
    requires spring.sandbox.back.main;
    requires spring.sandbox.security.main;
}