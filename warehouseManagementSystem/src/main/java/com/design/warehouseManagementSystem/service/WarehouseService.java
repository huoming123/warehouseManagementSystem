package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Warehouse;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Warehouse)表服务接口
 *
 * @author makejava
 */
public interface WarehouseService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Warehouse> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Warehouse> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Warehouse warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */


    RestFulBean<List<Delivery>> getWarehouseList(Warehouse warehouse);

    RestFulBean<String> deleteById(Warehouse warehouse);



    RestFulBean<Map> getWarehouseAnalyse(Warehouse warehouse);
}
