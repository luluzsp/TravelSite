package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/21 10:38
 * @description：Product持久层接口
 * @modified By：
 * @version:
 */
@Repository
public interface ProductDao {

    /**
     * @Author: luluzsp
     * @Description: 查询所有产品
     * @Date: 10:41 2019/11/21
     * @return: java.util.List<com.luluzsp.travel.entity.Product>
     * @Version: 1.0
     */
    @Select("select * from product")
    List<Product> findAll();


    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void InsertProduct(Product product);

    @Select("select * from product where id=#{id}")
    Product findProductById(String id);
}
