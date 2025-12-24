package org.template.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;
import org.template.models.TestUserDO;
import org.template.models.TestUserVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TestService extends BaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TestService(){

    }

    public void showMessage(){
        log.info("This is inside services");
    }

    public TestUserVO getAllUsersFromDB() {

        String sql = "SELECT id, username, email, password FROM users";

        TestUserVO testUserVO = new TestUserVO();

        List<TestUserDO> testUserDOList = jdbcTemplate.query(sql, (rs, rowNum) -> new TestUserDO(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        ));

        testUserVO.setTestUserDOList(testUserDOList);
        testUserVO.setTestUserDO(
                testUserDOList.stream().findFirst().orElse(new TestUserDO())
        );

        return testUserVO;
    }

}
