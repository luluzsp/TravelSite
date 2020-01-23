package com.luluzsp.travel.Dao;

import com.luluzsp.travel.entity.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/29 10:18
 * @description：Member数据层操作
 * @modified By：
 * @version:
 */
@Repository
public interface MemberDao {

    @Select("select * from member where id = #{id}")
    Member findMemberById(String Id);
}
