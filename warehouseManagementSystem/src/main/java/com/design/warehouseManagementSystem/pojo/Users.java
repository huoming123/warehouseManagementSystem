package com.design. warehouseManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since
 */
public class Users implements Serializable {
    private static final long serialVersionUID = -72244701399609938L;
     
    private Integer id;
     /**
     * 密码
     */
    private String password;
    private String oldPassword;
    private String newsPassword;
     /**
     * 手机号存个字符串11位
     */
    private String telephone;
     /**
     * 用户名
     */
    private String userName;
     /**
     * 身份证
     */
    private String cardId;

    private String userNo;
     /**
     * 角色
     */
    private String role;
    private Integer gradeYear;
    private Integer professionId;
    private Integer classeId;

    public String getNewsPassword() {
        return newsPassword;
    }

    public void setNewsPassword(String newsPassword) {
        this.newsPassword = newsPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(Integer gradeYear) {
        this.gradeYear = gradeYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

