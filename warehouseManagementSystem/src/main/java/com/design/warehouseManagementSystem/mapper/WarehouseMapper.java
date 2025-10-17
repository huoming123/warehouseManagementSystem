package com.design.warehouseManagementSystem.mapper;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Warehouse;
import java.util.List;
import com.design.warehouseManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Warehouse)表数据库访问层
 *
 * @author makejava
 */
public interface WarehouseMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Warehouse> getPageSearchByCondition(@Param("page") Page<Warehouse> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Warehouse> page);


    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int increased(Warehouse warehouse);




    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int edit(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Delivery> getWarehouseList(Warehouse warehouse);

    Warehouse getByWarehouseNo(String warehouseNo);

    List<Warehouse> getWarehouseAnalyse(Warehouse warehouse);
}

