package com.design.warehouseManagementSystem.service.impl;

import com.design.warehouseManagementSystem.mapper.ManagerMapper;
import com.design.warehouseManagementSystem.mapper.WarehousemanMapper;
import com.design.warehouseManagementSystem.pojo.Manager;
import com.design.warehouseManagementSystem.pojo.Users;
import com.design.warehouseManagementSystem.pojo.Warehouseman;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service("LoginService")
public class  LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private WarehousemanMapper warehousemanMapper;
    @Override
    public RestFulBean<Users> login(Users users) throws Exception {
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        Users user =new Users(); //new一个用户对象
        user.setRole(users.getRole());
        if(users.getRole().equals("仓库员")) //判断角色是否等于学生
        {

            Warehouseman warehouseman =warehousemanMapper.getByUserNo(users.getUserNo());//根据编号获取仓库员数据
            if(warehouseman==null){
                return RestFulBean.error("该仓库员用户不存在");
            }
            if(warehouseman.getChecked()==0){
            return RestFulBean.error("账号还未审核");
        }
            if(warehouseman.getChecked()==-1){
                return RestFulBean.error("账号审核不通过");
            }
            //赋值
            user.setId(warehouseman.getId());
            user.setUserName(warehouseman.getUserName());
            user.setUserNo(warehouseman.getUserNo());
            user.setPassword(warehouseman.getPassword());
        }
        if(users.getRole().equals("管理员")) //判断角色是否等于管理员
        {
            Manager manager =managerMapper.getByUserNo(users.getUserNo());//根据编号获取管理员数据
            if(manager==null){
                return RestFulBean.error("该管理员用户不存在");
            }
            if(manager.getChecked()==0){
                return RestFulBean.error("账号还未审核");
            }
            if(manager.getChecked()==-1){
                return RestFulBean.error("账号审核不通过");
            }
            //赋值
            user.setId(manager.getId());
            user.setUserName(manager.getUserName());
            user.setUserNo(manager.getUserNo());
            user.setPassword(manager.getPassword());
        }
            //判断密码跟数据库是否一样
            if(users.getPassword().equals(user.getPassword())){
                return RestFulBean.succ(user); //如果密码一样将用户对象放回到前端
            }
            else{
                return RestFulBean.error("密码错误");
            }
    }
}
