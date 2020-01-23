package com.luluzsp.travel.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/29 19:44
 * @description：权限实体类
 * @modified By：
 * @version:
 */
@Data
public class Permission implements Serializable {
    /** id **/
    private String id;
    /** 权限名称 **/
    private String permissionName;
    /** url **/
    private String url;
    /** 角色 **/
    private List<Role> roles;
}
