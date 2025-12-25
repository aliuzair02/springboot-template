package org.template.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;
import org.template.common.services.ObjectService;
import org.template.models.UserDO;
import org.template.models.UserVO;

import java.util.List;
import java.util.Objects;

@Service
public class UserService extends BaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserService(){

    }

    public UserVO getAllUsersFromDB() {

        String sql = "SELECT id, username, email, password FROM users";

        UserVO userVO = new UserVO();

        List<UserDO> userDOList = jdbcTemplate.query(sql, (rs, rowNum) -> new UserDO(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        ));

        userVO.setUserDOList(userDOList);
        userVO.setUserDO(
                userDOList.stream().findFirst().orElse(new UserDO())
        );

        return userVO;
    }

    public void saveNewUser(UserVO userVO) {

        UserDO userDO = userVO.getUserDO();

        // Check if username already exists
        String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(
                checkSql,
                Integer.class,
                userDO.getUsername()
        );

        if (count > 0) {
            ObjectService.setStatusVO(userVO, false, "Username already exists");
            throw new RuntimeException("Username already exists");
        }

        // Insert new user
        String insertSql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        int rows = jdbcTemplate.update(
                insertSql,
                userDO.getUsername(),
                userDO.getEmail(),
                userDO.getPassword()
        );

        if (rows > 0) {
            ObjectService.setStatusVO(userVO, true, "Successfully create new user");
        } else {
            ObjectService.setStatusVO(userVO, false, "Failed create new user");
        }
    }



}
