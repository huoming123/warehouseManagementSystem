package com.design.warehouseManagementSystem.mapper;

import com.design.warehouseManagementSystem.pojo.Warehouseman;
import java.util.List;
import com.design.warehouseManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Warehouseman)表数据库访问层
 *
 * @author makejava
 */
public interface WarehousemanMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Warehouseman queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Warehouseman> getPageSearchByCondition(@Param("page") Page<Warehouseman> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Warehouseman> page);


    /**
     * 新增数据
     *
     * @param warehouseman 实例对象
     * @return 影响行数
     */
    int increased(Warehouseman warehouseman);




    /**
     * 修改数据
     *
     * @param warehouseman 实例对象
     * @return 影响行数
     */
    int edit(Warehouseman warehouseman);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Warehouseman getByUserNo(String userNo);
}

