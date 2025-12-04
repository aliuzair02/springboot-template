package org.template.services;

import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;

@Service
public class TestService extends BaseService {

    public TestService(){

    }

    public void showMessage(){
        log.info("This is inside services");
    }

}
