package com.design.warehouseManagementSystem.mapper;

import com.design.warehouseManagementSystem.pojo.Delivery;
import java.util.List;
import com.design.warehouseManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Delivery)表数据库访问层
 *
 * @author makejava
 */
public interface DeliveryMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Delivery queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Delivery> getPageSearchByCondition(@Param("page") Page<Delivery> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Delivery> page);


    /**
     * 新增数据
     *
     * @param delivery 实例对象
     * @return 影响行数
     */
    int increased(Delivery delivery);




    /**
     * 修改数据
     *
     * @param delivery 实例对象
     * @return 影响行数
     */
    int edit(Delivery delivery);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Delivery> getDeliveryList(Delivery delivery);

    Delivery getByDeliveryNo(String deliveryNo);

    List<Delivery> getDeliveryAnalyse(Delivery delivery);
}

