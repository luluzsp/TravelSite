package com.luluzsp.travel.service.impl;

import com.luluzsp.travel.Dao.PermissionDao;
import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 20:26
 * @description：permission业务层实现类
 * @modified By：
 * @version:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAllPermission() {
        return permissionDao.findAllPermission();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
