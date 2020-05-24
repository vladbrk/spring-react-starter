package org.springsandbox.security.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springsandbox.security.repo.dto.Role;
import org.springsandbox.security.repo.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final static String SELECT_USER = "SELECT * FROM security.user WHERE username = ?";
    private final static String SELECT_ROLE = "SELECT * FROM security.role WHERE user_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsername(String username) {
        User user = jdbcTemplate.queryForObject(SELECT_USER, this::mapRowToUser, username);
        List<GrantedAuthority> gas = jdbcTemplate.query(SELECT_ROLE, this::mapRowToGrantedAuthority, user.getId());
        user.setGrantedAuthorities(gas);
        return user;
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    private GrantedAuthority mapRowToGrantedAuthority(ResultSet rs, int rowNum) throws SQLException {
        int role = rs.getInt("role");
        GrantedAuthority ga = () -> Role.find(role).toString();
        return ga;
    }
}
