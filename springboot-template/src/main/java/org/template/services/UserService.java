package org.template.services;

import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;
import org.template.dao.UserDaoJpa;
import org.template.models.UserDO;
import org.template.models.UserVO;
import org.template.tables.TbUser;

import java.util.Objects;


@Service
public class UserService extends BaseService {

    private final UserDaoJpa userDaoJpa;

    public UserService(UserDaoJpa userDaoJpa){
        this.userDaoJpa = userDaoJpa;
    }

    public UserVO getAllUsers() {

        return userDaoJpa.getAllUser();

    }

    public void saveUser(UserVO userVO) throws Exception {

        // Step 0 - null checking
        if (Objects.isNull(userVO) || Objects.isNull(userVO.getUserDO())) {
            return;
        }

        UserDO userDO = userVO.getUserDO();

        // Step 1 - set entity
        TbUser tbUser = new TbUser();
        tbUser.setId(userDO.getId());
        tbUser.setUsername(userDO.getUsername());
        tbUser.setPassword(userDO.getPassword());
        tbUser.setEmail(userDO.getEmail());

        // Step 2 - save or update
        if (Objects.isNull(tbUser.getId())) {
            userDaoJpa.save(tbUser);
        } else {
            if (Objects.isNull(userDaoJpa.getById(TbUser.class, userDO.getId()))) {
                throw new Exception("User id not exist");
            }
            userDaoJpa.update(tbUser);
        }

    }

    public void deleteUser(UserVO userVO) {

        // Step 0 - null checking
        if (Objects.isNull(userVO) || Objects.isNull(userVO.getUserDO())) {
            return;
        }

        UserDO userDO = userVO.getUserDO();

        // Step 1 - set entity
        TbUser tbUser = new TbUser();
        tbUser.setId(userDO.getId());
        tbUser.setUsername(userDO.getUsername());
        tbUser.setPassword(userDO.getPassword());
        tbUser.setEmail(userDO.getEmail());

        // Step 3 - delete
        userDaoJpa.delete(tbUser);

    }

}
