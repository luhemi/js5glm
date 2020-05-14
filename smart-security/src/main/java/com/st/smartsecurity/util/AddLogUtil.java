package com.st.smartsecurity.util;

import com.st.smartsecurity.mapper.LogMapper;
import com.st.smartsecurity.pojo.po.Log;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * @author xuri
 * @date 2019/10/24
 */
@Component
public class AddLogUtil {
    @Resource
    LogMapper logMapper;

    public void addLog(String comName, String msg){
        if (StringUtils.isEmpty(comName)){
            return;
        }
        Log log = new Log();
        log.setLoginName(comName);
        log.setCreateDate(new Date());
        log.setContent(msg);
        logMapper.insertSelective(log);
    }
}

