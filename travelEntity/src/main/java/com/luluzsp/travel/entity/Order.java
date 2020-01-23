package com.luluzsp.travel.entity;

import com.luluzsp.Utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 19:32
 * @description：订单实体类
 * @modified By：
 * @version:
 */
@Data
public class Order implements Serializable {

    /** 主键ID **/
    private String id;
    /** 订单号 **/
    private String orderNum;
    /** 订单创建时间 **/
    private Date orderTime;
    private String orderTimeStr;
    /** 订单状态 **/
    private int orderStatus;
    private int orderStatusStr;
    /** 出行人数 **/
    private int peopleCount;
    /** 产品信息 **/
    private Product product;
    /** 旅客信息 **/
    private List<Traveller> travellers;
    /** 会员信息 **/
    private Member member;
    /** 支付类型 **/
    private Integer payType;
    private String payTypeStr;
    /** 订单描述 **/
    private String orderDesc;

    public String getOrderStatusStr(){
        if(orderStatus==0){
            return "未支付";
        }else if(orderStatus==1){
            return "已支付";
        }else {
            return null;
        }
    }

    public String getOrderTimeStr(){
        if(orderTime!=null){
             return DateUtils.DateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }else{
            return  null;
        }
    }

    public  String getPayType(){
        if(0==payType){
            return "微信";
        }else if(1==payType){
            return "支付宝";
        }else{
            return "其他";
        }
    }
}
