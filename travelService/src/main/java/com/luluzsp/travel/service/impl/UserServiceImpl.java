package com.luluzsp.travel.service.impl;

import com.luluzsp.Utils.UUIDUtils;
import com.luluzsp.travel.Dao.UserDao;
import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.entity.UserInfo;
import com.luluzsp.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/4 11:03
 * @description：用于认证接口实现类
 * @modified By：
 * @version:
 */
@Transactional(rollbackFor = Exception.class)
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder  encoder;

    @Override
    public void saveUser(UserInfo userInfo) {
        String password = userInfo.getPassword();
        String temp = encoder.encode(password);
        userInfo.setPassword(temp);
        userInfo.setId(UUIDUtils.generateID());
        userDao.insertUser(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }


    @Override
    public UserInfo findUserById(String id) {

        return userDao.findUserById(id);
    }

    @Override
    /**
     * @Author: luluzsp
     * @Description:  用戶认证授权实现类类
     * @Date: 5:48 2019/12/14
     * @param username
     * @return: org.springframework.security.core.userdetails.UserDetails
     * @Version: 1.0
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库根据用户名查询到用户
         UserInfo userInfo= userDao.findUserByName(username);
        if(null==userInfo){
            return  null;
        }
        //封装spring security User对象
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,
                true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * @Author: luluzsp
     * @Description: 用户的角色进行授权
     * @Date: 5:50 2019/12/14
     * @param roles
     * @return: java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     * @Version: 1.0
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }


    @Override
    public List<Role> findAvailableRoleById(String id) {
        return userDao.findAvailableRoleById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.saveRoleToUser(userId,roleId);
        }
    }
}
