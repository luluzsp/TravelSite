package com.luluzsp.travel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 19:38
 * @description：旅客实体类
 * @modified By：
 * @version:
 */
@Data
public class Traveller implements Serializable {
    /** 主键信息 **/
    private String id;
    /** 姓名 **/
    private String name;
    /** 性别 **/
    private String sex;
    /** 电话号码 **/
    private String phoneNum;
    /** 证件类型 0身份证 1 护照 2 军官证 **/
    private Integer credentialsType;
    private String credentialsTypeStr;
    /** 证件号码 **/
    private String credentialsNum;
    /** 旅客类型  0成人 1儿童**/
    private Integer travellerType;
    private String travellerTypeStr;
}
