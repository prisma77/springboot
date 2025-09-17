package com.multi.springboot.controller;

import com.multi.springboot.model.UserDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("user")
    public UserDTO user(){
        return new UserDTO(11,"홍박사","a@a.a");
    }
}
