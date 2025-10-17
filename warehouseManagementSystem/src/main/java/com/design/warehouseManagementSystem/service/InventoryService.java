package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Inventory;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Inventory)表服务接口
 *
 * @author makejava
 */
public interface InventoryService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Inventory> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Inventory> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Inventory inventory);

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Inventory inventory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Inventory>> getProductList(Inventory inventory);

    RestFulBean<Inventory> getByName(Inventory inventory);

    RestFulBean<Map> getInventoryAnalyse(Inventory inventory);
}
