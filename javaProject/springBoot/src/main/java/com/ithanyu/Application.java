package com.ithanyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
// @RestController
@SpringBootApplication
public class Application {

    // @Autowired
    // private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // @GetMapping("/")
    // public List<User> index(){
    //     User user = new User();
    //     return userMapper.findAll();
    // }

    // @GetMapping("/")
    // public String index(){
    //     return "ok";
    // }

}
