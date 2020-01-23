package com.luluzsp.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.luluzsp.travel.Dao.OrderDao;
import com.luluzsp.travel.entity.Order;
import com.luluzsp.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 20:16
 * @description：Order业务逻辑类
 * @modified By：
 * @version:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll( int page,  int pageSize) throws Exception {

        PageHelper.startPage(page,pageSize);
        return orderDao.findAll();
    }

    @Override
    public List<Order> findAll( ) throws Exception {

        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) throws Exception {
        return orderDao.findById(id);
    }
}
