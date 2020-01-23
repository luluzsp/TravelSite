package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Traveller;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/29 10:50
 * @description：Traveller数据层操作
 * @modified By：
 * @version:
 */
@Repository
public interface TravellerDao {

    @Select("select * from traveller where id in(select travellerId  from order_traveller where orderId=#{id})")
    List<Traveller> findByOrderId(@Param("id") String id);
}
