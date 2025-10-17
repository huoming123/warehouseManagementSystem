package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Delivery)表服务接口
 *
 * @author makejava
 */
public interface DeliveryService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Delivery> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Delivery> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param delivery 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Delivery delivery);

    /**
     * 修改数据
     *
     * @param delivery 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Delivery delivery);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */


    RestFulBean<List<Delivery>> getDeliveryList(Delivery delivery);

    RestFulBean<String> deleteById(Delivery delivery);

    RestFulBean<Map> getDeliveryAnalyse(Delivery delivery);
}
