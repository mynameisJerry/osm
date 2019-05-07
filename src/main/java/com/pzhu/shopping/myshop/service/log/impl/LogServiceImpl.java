package com.pzhu.shopping.myshop.service.log.impl;

import com.pzhu.shopping.myshop.mapper.LogMapper;
import com.pzhu.shopping.myshop.pojo.log.TbLog;
import com.pzhu.shopping.myshop.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Date 2019/1/7 19:46
 * @Classname LogServiceImpl
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void addLog(TbLog tbLog) {
        logMapper.addLog(tbLog);
    }
}
