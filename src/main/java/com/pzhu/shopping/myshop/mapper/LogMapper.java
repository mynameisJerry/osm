package com.pzhu.shopping.myshop.mapper;
/**
 * @Classname LogMapper
 * @Description TODO
 * @Date 2019/1/7 19:45
 * @Created by Administrator
 */


import com.pzhu.shopping.myshop.pojo.log.TbLog;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Date 2019/1/7 19:45
 * @Classname LogMapper
 */
@Repository
public interface LogMapper {

    void addLog(TbLog tbLog);
}
