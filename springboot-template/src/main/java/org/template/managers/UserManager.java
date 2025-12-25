package org.template.managers;

import org.springframework.stereotype.Service;
import org.template.common.managers.BaseManager;
import org.template.common.services.ObjectService;
import org.template.models.UserVO;
import org.template.services.UserService;

@Service
public class UserManager extends BaseManager {

    private final UserService userService;

    public UserManager(UserService userService){
        this.userService = userService;
    }

    public UserVO getAllUsers(){

        log.info("Process getAllUsers Started");

        UserVO userVO =  userService.getAllUsersFromDB();

        ObjectService.setStatusVO(userVO, true, "Success");

        log.info("Process getAllUsers Ended");

        return userVO;

    }

    public void saveNewUser(UserVO userVO){

        try{
            log.info("Process saveNewUser Started");

            userService.saveNewUser(userVO);

            log.info("Process saveNewUser Ended");
        } catch (Exception e) {
            log.error(e.getMessage());
            ObjectService.setStatusVO(userVO, false, e.getMessage());
        }

    }

}
