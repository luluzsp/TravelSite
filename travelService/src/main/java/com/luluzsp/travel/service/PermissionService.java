package com.luluzsp.travel.service;

import com.luluzsp.travel.entity.Permission;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 20:25
 * @description：permission业务层接口
 * @modified By：
 * @version:
 */
public interface PermissionService {

    List<Permission> findAllPermission();
    void  save(Permission permission);
}
