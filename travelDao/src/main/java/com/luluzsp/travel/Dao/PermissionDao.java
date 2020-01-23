package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 14:02
 * @description：权限持久化层
 * @modified By：
 * @version:
 */
@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    Permission findPermissionByRoleId(@Param("roleId")String roleId);


    @Select("select * from permission")
    List<Permission> findAllPermission();

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
