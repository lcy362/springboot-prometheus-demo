package top.sand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sand.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/request/test")
    public void testMethod() {
        testService.callMethod();
        testService.asyncCall();
    }
}
