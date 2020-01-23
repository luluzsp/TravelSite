package com.luluzsp.travel.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/29 19:30
 * @description：角色实体类
 * @modified By：
 * @version:
 */
@Data
public class Role implements Serializable {
    /** id **/ 
    private String id;
    /** 角色名称 **/ 
    private String roleName;
    /** 角色描述 **/ 
    private String roleDesc;
    /** 权限 **/ 
    private List<Permission> permissions;
    /** 用户 **/
    private List<User> users;
}
