package com.design.warehouseManagementSystem.controller;

import com.design.warehouseManagementSystem.pojo.Storage;
import com.design.warehouseManagementSystem.service.StorageService;
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
 * (Storage)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    /**
     * 服务对象
     */
    @Autowired
    private StorageService storageService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Storage>page) throws Exception{
        return this.storageService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Storage> queryById(@RequestBody Storage storage) {
        return this.storageService.queryById(storage.getId());
    }

    /**
     * 新增数据
     *
     * @param storage 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Storage storage) {
        return this.storageService.increased(storage);
    }

    /**
     * 编辑数据
     *
     * @param storage 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Storage storage) {
        return this.storageService.edit(storage);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Storage storage) {
        return this.storageService.deleteById(storage.getId());
    }
    /**
     * 获取仓库下拉数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/get/storage/list")
    public RestFulBean<List<Storage>> getStorageList() throws Exception{
        return this.storageService.getStorageList();
    }
}

