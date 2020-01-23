package com.luluzsp.travel.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/29 19:28
 * @description：用户信息实体类
 * @modified By：
 * @version:
 */
@Data
public class UserInfo implements Serializable {
    /** id **/ 
    private String id;
    /** 用户名 **/ 
    private String username;
    /** 邮箱 **/ 
    private String email;
    /** 密码 **/ 
    private String password;
    /** 手机号码 **/ 
    private String phoneNum;
    /** 账号状态 **/ 
    private int status;
    private String statusStr;
    /** 角色 **/ 
    private List<Role> roles;

    public String getStatusStr(){
        return status==1?"激活":"冻结";
    }
}
