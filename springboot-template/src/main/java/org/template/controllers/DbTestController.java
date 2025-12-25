package org.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.template.models.UserDO;

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
    public List<UserDO> getAllUsers() {
        String sql = "SELECT id, username, email, password FROM users";

        return jdbcTemplate.query(sql, new RowMapper<UserDO>() {
            @Override
            public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserDO(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        });
    }
}
