package com.luluzsp.travel.service;

import com.luluzsp.travel.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/21 10:42
 * @description：Product业务层
 * @modified By：
 * @version:
 */
public interface ProductService {

    /**
     * @Author: luluzsp
     * @Description:查询所有产品信息
     * @Date: 13:45 2019/11/22
     * @return: java.util.List<com.luluzsp.travel.entity.Product>
     * @Version: 1.0
     */
    List<Product> findAll();


    /**
     * @Author: luluzsp
     * @Description: 添加新产品
     * @Date: 13:46 2019/11/22
     * @param product 产品信息
     * @return: void
     * @Version: 1.0
     */
    void saveProduct(Product product);
}
