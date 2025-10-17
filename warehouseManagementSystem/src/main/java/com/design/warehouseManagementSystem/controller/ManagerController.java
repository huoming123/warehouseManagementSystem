package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Manager;
import com.design.warehouseManagementSystem.pojo.Users;
import com.design.warehouseManagementSystem.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Manager)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    /**
     * 服务对象
     */
    @Autowired
    private ManagerService managerService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Manager>page) throws Exception{
        return this.managerService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Manager> queryById(@RequestBody Manager manager) {
        return this.managerService.queryById(manager.getId());
    }

    /**
     * 新增数据
     *
     * @param manager 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Manager manager) {
        return this.managerService.insert(manager);
    }

    /**
     * 编辑数据
     *
     * @param manager 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Manager manager) {
        return this.managerService.update(manager);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Manager manager) {
        return this.managerService.deleteById(manager.getId());
    }
    /**
     * 修改密码
     *
     */
    @PostMapping("/update/password")
    public RestFulBean<String> updatePassword(@RequestBody Users users) throws Exception{
        return this.managerService.updatePassword(users);
    }
}

