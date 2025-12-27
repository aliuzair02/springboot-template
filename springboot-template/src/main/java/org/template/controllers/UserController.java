package org.template.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.template.common.models.ResponseObject;
import org.template.common.services.ObjectService;
import org.template.managers.UserManager;
import org.template.models.UserDO;
import org.template.models.UserRequestObject;
import org.template.models.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    // Basic Create & Update
    @PostMapping("/save")
    public ResponseEntity<ResponseObject> save(@RequestBody UserRequestObject userRequestObject) {

        UserDO userDO = new UserDO();

        ObjectService.copyProperties(userRequestObject, userDO);

        UserVO userVO = new UserVO(userDO);

        userManager.saveUser(userVO);

        return ObjectService.getResponseBody(userVO);
    }

    // Basic Read
    @GetMapping("/getAll")
    public ResponseEntity<ResponseObject> getAll() {

        return ObjectService.getResponseBody(userManager.getAllUsers());
    }

    // Basic Delete
    @PostMapping("/delete")
    public ResponseEntity<ResponseObject> delete(@RequestBody UserRequestObject userRequestObject) {

        UserDO userDO = new UserDO();

        ObjectService.copyProperties(userRequestObject, userDO);

        UserVO userVO = new UserVO(userDO);

        userManager.deleteUser(userVO);

        return ObjectService.getResponseBody(userVO);
    }

}
