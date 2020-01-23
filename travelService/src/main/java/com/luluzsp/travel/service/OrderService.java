package com.luluzsp.travel.service;

import com.luluzsp.travel.entity.Order;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 19:50
 * @description：订单业务层
 * @modified By：
 * @version:
 */
public interface OrderService {

    /**
     * @Author: luluzsp
     * @Description: 查询所有订单
     * @Date: 20:15 2019/11/23
     * @return: java.util.List<com.luluzsp.travel.entity.Order>
     * @Version: 1.0
     */
   List<Order> findAll() throws Exception;


    /**
     * @Author: luluzsp
     * @Description: 分页查询
     * @Date: 10:29 2019/11/28
     * @param page
     * @param pageSize
     * @return: java.util.List<com.luluzsp.travel.entity.Order>
     * @Version: 1.0
     */
     List<Order> findAll( int page,  int pageSize) throws Exception;

     /**
      * @Author: luluzsp
      * @Description: 更久订单ID查询出订单,会员,随性人员等信息
      * @Date: 11:05 2019/11/29
      * @param orderId 订单ID
      * @return: java.util.List<com.luluzsp.travel.entity.Order>
      * @Version: 1.0
      */
     Order findById(String id) throws Exception;
}
