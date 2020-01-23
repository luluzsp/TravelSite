package com.luluzsp.travel.controller;

import com.github.pagehelper.PageInfo;
import com.luluzsp.travel.entity.Order;
import com.luluzsp.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 19:47
 * @description：Order接口
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

   /* @RequestMapping("/findAll")
    public ModelAndView  findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> orderList = orderService.findAll();
        mv.addObject("ordersList",orderList);
        mv.setViewName("orders-list");
        return  mv;
    }*/

   @RequestMapping("/findAll")
    public  ModelAndView findAll(@RequestParam(name="page", required = true,defaultValue = "1") int page,
                                 @RequestParam(name="pageSize",required = true,defaultValue = "5") int pageSize) throws Exception {
       List<Order> orderList = orderService.findAll(page, pageSize);
       PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView model = new ModelAndView();
        model.addObject("pageInfo",pageInfo);
        model.setViewName("orders-page-list");
        return  model;

    }


    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        Order order = orderService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}
