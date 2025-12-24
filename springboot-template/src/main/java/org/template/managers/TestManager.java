package org.template.managers;

import org.springframework.stereotype.Service;
import org.template.common.managers.BaseManager;
import org.template.common.services.ObjectService;
import org.template.models.TestUserDO;
import org.template.models.TestUserVO;
import org.template.models.TestVO;
import org.template.services.TestService;

import java.util.List;

@Service
public class TestManager extends BaseManager {
    private final TestService testService;

    public TestManager(TestService testService){
        this.testService = testService;
    }

    public void doSomething(TestVO testVO){

        log.info("Process Started");
        log.info("This is inside managers");

        testService.showMessage();

        ObjectService.setStatusVO(testVO, true, "Success");

        log.info("Process Ended");

    }

    public TestUserVO getAllUsers(){

        log.info("Process getAllUsers Started");

        TestUserVO testUserVO =  testService.getAllUsersFromDB();

        ObjectService.setStatusVO(testUserVO, true, "Success");

        log.info("Process getAllUsers Ended");

        return testUserVO;

    }

}
