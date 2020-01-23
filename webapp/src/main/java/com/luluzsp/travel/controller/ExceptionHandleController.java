package com.luluzsp.travel.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/12/17 8:29
 * @description：异常处理类
 * @modified By：
 * @version:
 */
@ControllerAdvice
public class ExceptionHandleController  {

    @ExceptionHandler(AccessDeniedException.class)
    public String  Handle4O3(){
        return "forward:/403.jsp";
    }

    @ExceptionHandler(RuntimeException.class)
    public String  Handle500(){
        return "forward:/500.jsp";
    }

}
