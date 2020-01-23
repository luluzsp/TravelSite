package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/4 14:36
 * @description：Role持久化接口
 * @modified By：
 * @version:
 */
@Repository
public interface RoleDao {

    @Select("select * from role where id in(select roleId from users_role where userId =#{userId})")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select ="com.luluzsp.travel.Dao.PermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String userId);


    @Select("select * from role")
    List<Role> findAllRole();

    @Select("select * from role where id =#{id}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select ="com.luluzsp.travel.Dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findRoleById(String id);


    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void insertRole(Role role);


    @Select("select * from permission where id not in( select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findAvailablePermissionByRoleId(String roleId);


    @Insert("insert into role_permission values(#{roleId},#{permissionId})")
    void savePermissionToRole(@Param("permissionId") String roleId,@Param("roleId") String permissionId);
}
