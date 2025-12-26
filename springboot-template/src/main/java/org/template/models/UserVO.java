package org.template.models;

import org.template.common.models.BaseVO;

import java.util.List;

public class UserVO extends BaseVO {
    private UserDO userDO;
    private List<UserDO> userDOList;

    public UserVO() {}

    public UserVO(UserDO userDO) {
        this.userDO = userDO;
    }

    public UserVO(List<UserDO> userDOList) {
        this.userDOList = userDOList;
    }

    public List<UserDO> getUserDOList() {
        return userDOList;
    }

    public void setUserDOList(List<UserDO> userDOList) {
        this.userDOList = userDOList;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }
}
