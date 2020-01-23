package com.luluzsp.travel.controller;

import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.entity.UserInfo;
import com.luluzsp.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/4 18:59
 * @description：用户接口
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping(("/user"))
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAllUser(){
        List<UserInfo> userInfoList=userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("saveUser")
    public String saveUser(UserInfo userInfo){
        userService.saveUser(userInfo);
        //后台获取登录用户的名称
        String username =SecurityContextHolder.getContext().getAuthentication().getName();
        return "redirect:findAll";
    }

    @RequestMapping ({"/findUserById"})
     public ModelAndView findUserById(String id) {
        UserInfo userInfo = userService.findUserById(id);
        ModelAndView mv  = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return  mv;
    }

    @RequestMapping("/addRole")
    public ModelAndView addRole(@RequestParam("id") String userId){
        UserInfo userInfo = userService.findUserById(userId);
        List<Role> roleList = userService.findAvailableRoleById(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.addObject("user",userInfo);
        mv.setViewName("user-role-add");
        return  mv;
    }


    @RequestMapping("/addRoleToUser")
    public String saveRoleByUserId(@RequestParam(name = "userId",required = true) String userId,@RequestParam("ids") String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:/user/findAll";
    }
}
