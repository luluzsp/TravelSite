package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/4 11:08
 * @description：用户持久层接口
 * @modified By：
 * @version:
 */
public interface UserDao {

    /**
     * @Author: luluzsp
     * @Description: 根据用户名查找用户信息
     * @Date: 11:11 2019/12/4
     * @param username 用户名
     * @return: com.luluzsp.travel.entity.UserInfo
     * @Version: 1.0
     */
    @Select("select * from users where username=#{username}")
    @Results({
     @Result(id = true, column = "id",property = "id"),
     @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "email",property = "email"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType =java.util.List.class,many = @Many(select = "com.luluzsp.travel.Dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findUserByName(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users values (#{userInfo.id},#{userInfo.email},#{userInfo.username},#{userInfo.password},#{userInfo.phoneNum},#{userInfo.status})")
    void  insertUser(@Param("userInfo") UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "email",property = "email"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType =java.util.List.class,many = @Many(select = "com.luluzsp.travel.Dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findUserById(String id);


    @Select("select *  from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findAvailableRoleById(String userId);

    @Insert("insert into users_role value (#{userId},#{roleId})")
   void  saveRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
