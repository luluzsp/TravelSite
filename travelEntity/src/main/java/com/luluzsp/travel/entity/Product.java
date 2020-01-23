package com.luluzsp.travel.entity;

import com.luluzsp.Utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/21 9:38
 * @description：产品实体类
 * @modified By：
 * @version:
 */
@Data
public class Product {
    /** 主键 **/
    private String id;
    /** 编号 **/
    private String productNum;
    /** 产品名称 **/
    private String productName;
    /** 出发城市 **/
    private String cityName;
    /** 出发时间 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;

    private String departureTimeStr;

    public String getDepartureTimeStr(){

        if(departureTime!=null){
            departureTimeStr = DateUtils.DateToString(departureTime,"yyyy-MM-dd HH:mm:ss");

        }
        return departureTimeStr;
    }

    /** 产品价格 **/
    private double productPrice;
    /** 产品描述 **/
    private String productDesc;
    /** 状态 0 关闭 1 开启 **/
    private Integer productStatus;
    private String productStatusStr;

    public String getProductStatusStr(){
        if(productStatus==0){
            productStatusStr="关闭";
        }else if(productStatus==1){
            productStatusStr="开启";
        }

        return productStatusStr;
    }
}
