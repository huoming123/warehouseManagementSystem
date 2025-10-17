package com.design.warehouseManagementSystem.mapper;

import com.design.warehouseManagementSystem.pojo.Manager;
import java.util.List;
import com.design.warehouseManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Manager)表数据库访问层
 *
 * @author makejava
 */
public interface ManagerMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Manager queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Manager> getPageListByCondition(@Param("page") Page<Manager> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Manager> page);


    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int insert(Manager manager);




    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Manager getByUserNo(String userNo);

    ;
}

