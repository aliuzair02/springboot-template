package org.template.managers;

import org.springframework.stereotype.Service;
import org.template.common.constants.MessageConstants;
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

    public void saveUser(UserVO userVO){

        generateLogId();

        try{

            infoLog("Process saveUser Started");

            userService.saveUser(userVO);

            ObjectService.setStatusVO(userVO, true, MessageConstants.successMessage);

            infoLog("Process saveUser Ended");

        } catch (Exception e) {
            errorLog(e.getMessage());
            ObjectService.setStatusVO(userVO, false, ObjectService.getErrorMessage(e));
        }

    }

    public UserVO getAllUsers(){

        infoLog("Process getAllUsers Started");

        UserVO userVO =  userService.getAllUsers();

        ObjectService.setStatusVO(userVO, true, MessageConstants.successMessage);

        infoLog("Process getAllUsers Ended");

        return userVO;

    }

    public void deleteUser(UserVO userVO){

        generateLogId();

        try{

            infoLog("Process deleteUser Started");

            userService.deleteUser(userVO);

            ObjectService.setStatusVO(userVO, true, MessageConstants.successMessage);

            infoLog("Process deleteUser Ended");

        } catch (Exception e) {
            errorLog(e.getMessage());
            ObjectService.setStatusVO(userVO, false, ObjectService.getErrorMessage(e));
        }

    }

}
