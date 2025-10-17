package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Warehouseman;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Warehouseman)表服务接口
 *
 * @author makejava
 */
public interface WarehousemanService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Warehouseman> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Warehouseman> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param warehouseman 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Warehouseman warehouseman);

    /**
     * 修改数据
     *
     * @param warehouseman 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Warehouseman warehouseman);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
