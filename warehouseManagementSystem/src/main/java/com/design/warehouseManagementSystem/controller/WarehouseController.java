package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Warehouse;
import com.design.warehouseManagementSystem.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Warehouse)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    /**
     * 服务对象
     */
    @Autowired
    private WarehouseService warehouseService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Warehouse>page) throws Exception{
        return this.warehouseService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Warehouse> queryById(@RequestBody Warehouse warehouse) {
        return this.warehouseService.queryById(warehouse.getId());
    }

    /**
     * 新增数据
     *
     * @param warehouse 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Warehouse warehouse) {
        return this.warehouseService.increased(warehouse);
    }

    /**
     * 编辑数据
     *
     * @param warehouse 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Warehouse warehouse) {
        return this.warehouseService.edit(warehouse);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Warehouse warehouse) {
        return this.warehouseService.deleteById(warehouse);
    }
    /**
     * 根据物品名称获取出库记录
     *
     * @param
     * @return
     */
    @PostMapping("/get/warehouse/list")
    public RestFulBean<List<Delivery>> getDeliveryList(@RequestBody Warehouse warehouse) throws Exception{
        return this.warehouseService.getWarehouseList(warehouse);
    }
    /**
     * 入库统计分析
     *
     * @param tBor 实体
     * @return 编辑结果
     */
    @PostMapping("/getWarehouseAnalyse")
    public RestFulBean<Map> getWarehouseAnalyse(@RequestBody  Warehouse warehouse) {
        return this.warehouseService.getWarehouseAnalyse(warehouse);
    }
}

