package com.luluzsp.travel.service;

import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/4 11:02
 * @description：用户认证接口
 * @modified By：
 * @version:
 */
public interface UserService extends UserDetailsService {

    /**
     * @Author: luluzsp
     * @Description: 查询所有的账号信息
     * @Date: 19:05 2019/12/4
     * @return: java.util.List<com.luluzsp.travel.entity.UserInfo>
     * @Version: 1.0
     */
    List<UserInfo> findAll();

    /**
     * @Author: luluzsp
     * @Description: 添加用户
     * @Date: 14:21 2019/12/7
     * @param userInfo
     * @return: void
     * @Version: 1.0
     */
    void saveUser(UserInfo userInfo);
    /**
     * @Author: luluzsp
     * @Description: 根据用户ID 查询用户信息
     * @Date: 14:21 2019/12/7
     * @param id
     * @return: com.luluzsp.travel.entity.UserInfo
     * @Version: 1.0
     */
    UserInfo findUserById(String id);



    /**
     * @Author: luluzsp
     * @Description: 根据用户ID 查询用户还可以添加的权限
     * @Date: 14:22 2019/12/7
     * @param id
     * @return: java.util.List<com.luluzsp.travel.entity.Role>
     * @Version: 1.0
     */
    List<Role> findAvailableRoleById(String id);

    /**
     * @Author: luluzsp
     * @Description: 根据userId 和角色Id 给用户添加角色
     * @Date: 22:50 2019/12/11
     * @Version: 1.0
     */
    void addRoleToUser(String userId,String [] roleIds);
}
