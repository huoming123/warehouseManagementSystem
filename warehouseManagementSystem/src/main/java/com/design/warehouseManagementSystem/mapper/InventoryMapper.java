package com.design.warehouseManagementSystem.mapper;

import com.design.warehouseManagementSystem.pojo.Inventory;
import java.util.List;
import com.design.warehouseManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Inventory)表数据库访问层
 *
 * @author makejava
 */
public interface InventoryMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Inventory queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Inventory> getPageSearchByCondition(@Param("page") Page<Inventory> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Inventory> page);


    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 影响行数
     */
    int increased(Inventory inventory);




    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 影响行数
     */
    int edit(Inventory inventory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Inventory getByProductNo(String productNo);

    Inventory getByProductName(String productName);

    List<Inventory> getProductList();

    List<Inventory> getInventoryAnalyse(Inventory inventory);
}

