package com.luluzsp.travel.controller;

import com.luluzsp.Utils.UUIDUtils;
import com.luluzsp.travel.entity.Permission;
import com.luluzsp.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/5 20:18
 * @description：权限controller
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAllPermission")
    public ModelAndView findAllPermission(){
        List<Permission> permissionList = permissionService.findAllPermission();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return  mv;
    }

    @RequestMapping("/savePermission")
    public String savePermission(Permission permission){
        permission.setId(UUIDUtils.generateID());
        permissionService.save(permission);
        return "redirect:/permission/findAllPermission";
    }
}
