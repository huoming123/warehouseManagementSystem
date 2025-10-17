package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Users;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;

import java.util.Map;

public interface LoginService {

    RestFulBean<Users> login(Users users) throws Exception;
}
