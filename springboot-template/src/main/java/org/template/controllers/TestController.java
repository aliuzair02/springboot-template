package org.template.controllers;

import org.template.common.models.ResponseObject;
import org.template.common.services.ObjectService;
import org.template.managers.TestManager;
import org.template.managers.UserManager;
import org.template.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private final TestManager testManager;
    private final UserManager userManager;

    private Map<String, TestVO> test = new HashMap<>();

    public TestController(TestManager testManager, UserManager userManager){
        this.testManager = testManager;
        this.userManager = userManager;
        test.put("x1", new TestVO("x1","y1",1));
        test.put("x2", new TestVO("x2","y2",2));
    }

    @GetMapping("/")
    public String getHelloWorld(){
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/test1")
    public String getTest1(){
        return "<h1>Test1</h1>";
    }

    @GetMapping("/test2/{x}")
    public String test2(@PathVariable("x") String x){
        return x;
    }

    @GetMapping("/test3")
    public TestVO test3(){
        return new TestVO("x","y",10);
    }

    @GetMapping("/test4/{x}")
    public TestVO test4(@PathVariable("x") String x){
        return test.get(x);
    }

    @PostMapping("/test5")
    public void test5(@RequestBody TestVO x){
        test.put(x.getX(), x);
    }

    // to change response status
    @PostMapping("/test6")
    public ResponseEntity<ResponseObject> test6(@RequestBody TestRequestObject testRequestObject) {

        TestVO testVO = new TestVO();

        ObjectService.copyProperties(testRequestObject, testVO);

        testManager.doSomething(testVO);

        return ObjectService.getResponseBody(testVO);
    }

    @GetMapping("/test7")
    public ResponseEntity<ResponseObject> test7() {

        return ObjectService.getResponseBody(userManager.getAllUsers());
    }

    @PostMapping("/test8")
    public ResponseEntity<ResponseObject> test8(@RequestBody UserRequestObject userRequestObject) {

        UserDO userDO = new UserDO();

        ObjectService.copyProperties(userRequestObject, userDO);

        UserVO userVO = new UserVO(userDO);

        userManager.saveNewUser(userVO);

        return ObjectService.getResponseBody(userVO);
    }

}
