package org.template.services;

import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;
import org.template.common.services.ObjectService;
import org.template.dao.UserDaoJpa;
import org.template.models.UserDO;
import org.template.models.UserVO;


@Service
public class UserService extends BaseService {

    private final UserDaoJpa userDaoJpa;

    public UserService(UserDaoJpa userDaoJpa){
        this.userDaoJpa = userDaoJpa;
    }

    public UserVO getAllUsers() {

        return userDaoJpa.getAllUser();

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
