package org.springsandbox.back.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springsandbox.back.repo.dto.Contractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Deprecated
public class JdbcContractorRepository implements ContractorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    private ObjectMapper mapper;

    @Autowired
    public JdbcContractorRepository(JdbcTemplate jdbcTemplate) {
        jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName("ministry")
                .withTableName("contractor")
                .usingGeneratedKeyColumns("id");
    }




    @Override
    public Contractor findOne(Long id) {
        Contractor contractor = jdbcTemplate.queryForObject("SELECT * FROM ministry.contractor WHERE id = :id", this::mapRowToContract, id);
        return contractor;
    }

    @Override
    public List<Contractor> findAll() {
        List<Contractor> contractors = jdbcTemplate.query("SELECT * FROM ministry.contractor", this::mapRowToContract);
        return contractors;
    }

    @Override
    public void insert(Contractor contractor) {
        //Map<String, Object> values = mapper.convertValue(contractor, Map.class);
        Map<String, Object> values = new HashMap<>();
        values.put("name", contractor.getName());
        long id = jdbcInsert.executeAndReturnKey(values).longValue();
        contractor.setId(id);
    }

    private Contractor mapRowToContract(ResultSet rs, int rowNum) throws SQLException {
        Contractor c = new Contractor();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        return c;
    }
}
