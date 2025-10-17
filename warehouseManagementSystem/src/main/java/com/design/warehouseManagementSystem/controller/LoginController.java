package com.design.warehouseManagementSystem.controller;


import com.design.warehouseManagementSystem.pojo.Users;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     *
     * @param Users 需要name和password
     * @return data token
     */
    @PostMapping("/login")
    public RestFulBean<Users> login(@RequestBody  Users Users) throws Exception {
        return loginService.login(Users);
    }
}
