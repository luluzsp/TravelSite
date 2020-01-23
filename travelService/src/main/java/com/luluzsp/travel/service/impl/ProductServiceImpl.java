package com.luluzsp.travel.service.impl;

import com.luluzsp.travel.Dao.ProductDao;
import com.luluzsp.travel.entity.Product;
import com.luluzsp.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/21 10:46
 * @description：Product业务层实现类
 * @modified By：
 * @version:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.InsertProduct(product);
    }
}
