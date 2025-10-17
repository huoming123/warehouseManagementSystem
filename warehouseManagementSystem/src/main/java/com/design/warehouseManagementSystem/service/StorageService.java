package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.Storage;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import com.design.warehouseManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Storage)表服务接口
 *
 * @author makejava
 */
public interface StorageService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Storage> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Storage> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Storage storage);

    /**
     * 修改数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Storage storage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Storage>> getStorageList();
}
