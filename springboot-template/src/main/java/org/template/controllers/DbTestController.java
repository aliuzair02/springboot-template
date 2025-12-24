package org.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.template.models.TestUserDO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/db")
public class DbTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String testDb() {
        return jdbcTemplate.queryForObject("SELECT 'DB Connected!'", String.class);
    }

    @GetMapping("/users")
    public List<TestUserDO> getAllUsers() {
        String sql = "SELECT id, username, email, password FROM users";

        return jdbcTemplate.query(sql, new RowMapper<TestUserDO>() {
            @Override
            public TestUserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TestUserDO(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        });
    }
}
