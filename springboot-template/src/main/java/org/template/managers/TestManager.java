package org.template.managers;

import org.springframework.stereotype.Service;
import org.template.common.managers.BaseManager;
import org.template.common.services.ObjectService;
import org.template.models.UserVO;
import org.template.models.TestVO;
import org.template.services.TestService;

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

}
