package com.luluzsp.travel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/23 19:40
 * @description：会员信息
 * @modified By：
 * @version:
 */
@Data
public class Member implements Serializable {
    /**  ID **/
    private String id;
    /** 名称 **/
    private String name;
    /** 昵称 **/
    private String nickname;
    /** 电话号码 **/
    private String phoneNum;
    /** 邮箱 **/
    private String email;
}
