package com.luluzsp.travel.service.impl;

import com.luluzsp.travel.Dao.RoleDao;
import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 19:47
 * @description：Role业务层
 * @modified By：
 * @version:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
   private  RoleDao roleDao;

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.insertRole(role);
    }

    @Override
    public List<Permission> findAvailablePermissionByRoleId(String roleId) {
        return roleDao.findAvailablePermissionByRoleId(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.savePermissionToRole(roleId,permissionId);
        }
    }
}
