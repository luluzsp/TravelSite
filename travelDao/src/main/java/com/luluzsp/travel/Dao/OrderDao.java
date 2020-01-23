package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Member;
import com.luluzsp.travel.entity.Order;
import com.luluzsp.travel.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 11/28/2019 1:47:08 PM +08:00
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 20:13
 * @description：Order数据层接口
 * @modified By：
 * @version:
 */
@Repository
public interface OrderDao {


    @Select("select * from orders")
    @Results({
            @Result(id=true,property ="id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            //@Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.luluzsp.travel.Dao.ProductDao.findProductById")),
    })

    List<Order>  findAll()throws  Exception;


    @Select("select *  from orders where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select="com.luluzsp.travel.Dao.ProductDao.findProductById")),
            @Result(property = "member",column = "memberId" ,javaType = Member.class,one=@One(select="com.luluzsp.travel.Dao.MemberDao.findMemberById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many=@Many(select="com.luluzsp.travel.Dao.TravellerDao.findByOrderId"))
    })
    Order findById(@Param("id") String id) throws Exception ;
}
