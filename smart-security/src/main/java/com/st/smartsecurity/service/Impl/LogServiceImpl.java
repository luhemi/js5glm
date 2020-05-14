package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.mapper.LogMapper;
import com.st.smartsecurity.pojo.dto.LogDTO;
import com.st.smartsecurity.pojo.po.Log;
import com.st.smartsecurity.pojo.vo.params.LogParamsVO;
import com.st.smartsecurity.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Resource
    LogMapper logMapper;

    @Override
    public PageInfo<LogDTO> listLog(LogParamsVO logParamsVO) {
        Example example = new Example(Log.class);
        Example.Criteria criteria = example.createCriteria();
//        if (logParamVO.getName()!=null){
//            criteria.andLike("name","%"+logParamVO.getName()+"%");
//        }
//        if (logParamVO.getCreateDate()!=null){
//            criteria.andBetween("createDate", DateUtil.getDayBegin(logParamVO.getCreateDate()),DateUtil.getDayEnd(logParamVO.getCreateDate()));
//        }
        example.setOrderByClause("create_date DESC");
        //设置分页
        PageHelper.startPage(logParamsVO.getPageNum(),logParamsVO.getPageSize());
        //List查询
        List<Log> logs = logMapper.selectByExample(example);
        //处理结果
        PageInfo pageInfo = new PageInfo(logs);
        List<Log> pageInfoList = pageInfo.getList();
        //创建返回值
        List<LogDTO> logDTOList = Lists.newArrayList();
        for (Log log : pageInfoList){
            LogDTO logDTO = BeanUtil.copyProperties(log, LogDTO.class);
            logDTO.setLogId(log.getId());
            logDTOList.add(logDTO);
        }
        pageInfo.setList(logDTOList);
        return pageInfo;
    }
}
