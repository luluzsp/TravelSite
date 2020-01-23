package com.luluzsp.travel.controller;

import com.luluzsp.Utils.UUIDUtils;
import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.entity.Role;
import com.luluzsp.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 19:41
 * @description：角色管理
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ModelAndView findAllRole(){
        List<Role> roleList = roleService.findAllRole();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/findRoleById")
    public ModelAndView findRoleById(String id){
        Role role = roleService.findRoleById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("",role);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/saveRole")
    public String saveRole(Role role){
        role.setId(UUIDUtils.generateID());
        roleService.saveRole(role);
        return "redirect:/role/findAllRole";
    }


    @RequestMapping("/findRoleByIdAndAllPermission")
    public  ModelAndView findRoleByIdAndAllPermission(@RequestParam("id") String roleId){
        Role role = roleService.findRoleById(roleId);
        List<Permission> permissionList = roleService.findAvailablePermissionByRoleId(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public  String addPermissionToRole(@RequestParam("roleId") String roleId,@RequestParam("ids") String [] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:/role/findAllRole";
    }
}
