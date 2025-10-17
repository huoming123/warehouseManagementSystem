package com.design.warehouseManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Delivery)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:19:58
 */
public class Delivery implements Serializable {
    private static final long serialVersionUID = 264581972602768579L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 出库单号
     */
    private String deliveryNo;
     /**
     * 商品名称
     */
    private String productName;
     /**
     * 数量
     */
    private Integer total;
     /**
     * 录入时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd  HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 仓库员id
     */
    private Integer warehousemanId;
     /**
     * 出库原因
     */
    private String reason;
    private Integer count;
    private Integer year;
    private String month;
    private String yearMonth;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getWarehousemanId() {
        return warehousemanId;
    }

    public void setWarehousemanId(Integer warehousemanId) {
        this.warehousemanId = warehousemanId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}

