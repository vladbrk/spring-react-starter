module springsandbox.core {
    requires spring.context;
    requires spring.jdbc;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
    requires java.sql;
    requires java.persistence;
    requires lombok;
    exports org.springsandbox.core.configuration;
    exports org.springsandbox.core.repo.entity;
}