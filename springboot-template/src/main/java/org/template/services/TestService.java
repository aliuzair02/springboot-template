package org.template.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.template.common.services.BaseService;
import org.template.models.UserDO;
import org.template.models.UserVO;

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

}
