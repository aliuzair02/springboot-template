package org.template.models;

import org.template.common.models.BaseVO;

import java.util.List;

public class TestUserVO extends BaseVO {
    private TestUserDO testUserDO;
    private List<TestUserDO> testUserDOList;

    public TestUserVO() {}

    public List<TestUserDO> getTestUserDOList() {
        return testUserDOList;
    }

    public void setTestUserDOList(List<TestUserDO> testUserDOList) {
        this.testUserDOList = testUserDOList;
    }

    public TestUserDO getTestUserDO() {
        return testUserDO;
    }

    public void setTestUserDO(TestUserDO testUserDO) {
        this.testUserDO = testUserDO;
    }
}
