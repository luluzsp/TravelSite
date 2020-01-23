package com.luluzsp.Utils;

import java.util.UUID;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/22 13:50
 * @description：ID生成工具类
 * @modified By：
 * @version:
 */
public class UUIDUtils {

    public static String generateID(){
       String uuid =  UUID.randomUUID().toString().replaceAll("-", "");
       return uuid.substring(0,18);
    }
}
