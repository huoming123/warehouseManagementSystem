package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Inventory;
import com.design.warehouseManagementSystem.service.InventoryService;
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
 * (Inventory)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    /**
     * 服务对象
     */
    @Autowired
    private InventoryService inventoryService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Inventory>page) throws Exception{
        return this.inventoryService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Inventory> queryById(@RequestBody Inventory inventory) {
        return this.inventoryService.queryById(inventory.getId());
    }

    /**
     * 新增数据
     *
     * @param inventory 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Inventory inventory) {
        return this.inventoryService.increased(inventory);
    }

    /**
     * 编辑数据
     *
     * @param inventory 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Inventory inventory) {
        return this.inventoryService.edit(inventory);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Inventory inventory) {
        return this.inventoryService.deleteById(inventory.getId());
    }
    /**
     * 获取物品下拉数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/product/list")
    public RestFulBean<List<Inventory>> getMedicinesList(@RequestBody Inventory inventory) throws Exception{
        return this.inventoryService.getProductList(inventory);
    }

    /**
     * 根据物品名称获取数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/name")
    public RestFulBean<Inventory> getByName(@RequestBody Inventory inventory) throws Exception{
        return this.inventoryService.getByName(inventory);
    }
    /**
     * 库存统计分析
     *
     * @param tBor 实体
     * @return 编辑结果
     */
    @PostMapping("/getInventoryAnalyse")
    public RestFulBean<Map> getInventoryAnalyse(@RequestBody Inventory inventory) {
        return this.inventoryService.getInventoryAnalyse(inventory);
    }
}

