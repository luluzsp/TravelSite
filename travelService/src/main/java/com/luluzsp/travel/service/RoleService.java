package com.luluzsp.travel.service;

import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.entity.Role;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 19:46
 * @description：Role业务层
 * @modified By：
 * @version:
 */
public interface RoleService {

    List<Role> findAllRole();

    Role findRoleById(String id);

    void  saveRole(Role role);
    List<Permission> findAvailablePermissionByRoleId(String roleId);

    void addPermissionToRole(String roleId,String [] permissionIds);
}
