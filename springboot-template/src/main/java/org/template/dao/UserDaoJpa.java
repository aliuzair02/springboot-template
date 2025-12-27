package org.template.dao;

import org.springframework.stereotype.Repository;
import org.template.common.services.ObjectService;
import org.template.models.UserDO;
import org.template.models.UserVO;
import org.template.tables.TbUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoJpa extends DaoJpa{

    public UserVO getAllUser(){

        UserVO userVO = new UserVO();

        List<UserDO> userDOList = new ArrayList<>();
        List<TbUser> tbUserList = this.getAll(TbUser.class);

        for (TbUser tbUser : tbUserList) {
            UserDO userDO = new UserDO();
            ObjectService.copyProperties(tbUser, userDO);
            userDOList.add(userDO);

            if (Objects.isNull(userVO.getUserDO())) {
                userVO.setUserDO(userDO);
            }
        }

        userVO.setUserDOList(userDOList);

        return userVO;
    }



}
