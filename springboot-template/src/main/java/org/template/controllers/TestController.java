package org.template.controllers;

import org.template.models.TestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private Map<String, TestModel> test = new HashMap<>();

    public TestController(){
        test.put("x1", new TestModel("x1","y1",1));
        test.put("x2", new TestModel("x2","y2",2));
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
    public TestModel test3(){
        return new TestModel("x","y",10);
    }

    @GetMapping("/test4/{x}")
    public TestModel test4(@PathVariable("x") String x){
        return test.get(x);
    }

    @PostMapping("/test5")
    public void test5(@RequestBody TestModel x){
        test.put(x.getX(), x);
    }

    // to change response status
    @PostMapping("/test6")
    public ResponseEntity<HttpStatus> test6(@RequestBody TestModel x){
        test.put(x.getX(), x);
        return ResponseEntity.accepted().build();
    }

}
