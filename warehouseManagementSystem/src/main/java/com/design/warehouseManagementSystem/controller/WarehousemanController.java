package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Warehouseman;
import com.design.warehouseManagementSystem.service.WarehousemanService;
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
 * (Warehouseman)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/warehouseman")
public class WarehousemanController {
    /**
     * 服务对象
     */
    @Autowired
    private WarehousemanService warehousemanService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Warehouseman>page) throws Exception{
        return this.warehousemanService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Warehouseman> queryById(@RequestBody Warehouseman warehouseman) {
        return this.warehousemanService.queryById(warehouseman.getId());
    }

    /**
     * 新增数据
     *
     * @param warehouseman 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Warehouseman warehouseman) {
        return this.warehousemanService.increased(warehouseman);
    }

    /**
     * 编辑数据
     *
     * @param warehouseman 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Warehouseman warehouseman) {
        return this.warehousemanService.edit(warehouseman);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Warehouseman warehouseman) {
        return this.warehousemanService.deleteById(warehouseman.getId());
    }

}

