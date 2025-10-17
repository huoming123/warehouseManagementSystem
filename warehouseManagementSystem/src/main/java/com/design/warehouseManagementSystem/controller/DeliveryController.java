package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Warehouse;
import com.design.warehouseManagementSystem.service.DeliveryService;
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
 * (Delivery)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    /**
     * 服务对象
     */
    @Autowired
    private DeliveryService deliveryService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Delivery>page) throws Exception{
        return this.deliveryService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Delivery> queryById(@RequestBody Delivery delivery) {
        return this.deliveryService.queryById(delivery.getId());
    }

    /**
     * 新增数据
     *
     * @param delivery 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Delivery delivery) {
        return this.deliveryService.increased(delivery);
    }

    /**
     * 编辑数据
     *
     * @param delivery 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Delivery delivery) {
        return this.deliveryService.edit(delivery);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Delivery delivery) {
        return this.deliveryService.deleteById(delivery);
    }
    /**
     * 根据物品名称获取出库记录
     *
     * @param
     * @return
     */
    @PostMapping("/get/delivery/list")
    public RestFulBean<List<Delivery>> getDeliveryList(@RequestBody Delivery delivery) throws Exception{
        return this.deliveryService.getDeliveryList(delivery);
    }
    /**
     * 出库统计分析
     *
     * @param tBor 实体
     * @return 编辑结果
     */
    @PostMapping("/getDeliveryAnalyse")
    public RestFulBean<Map> getWarehouseAnalyse(@RequestBody  Delivery delivery) {
        return this.deliveryService.getDeliveryAnalyse(delivery);
    }
}

