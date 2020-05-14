package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.dto.CompanyScaleDTO;
import com.st.smartsecurity.pojo.dto.ScreenBaseDTO;
import com.st.smartsecurity.pojo.dto.ScreenProductDTO;
import com.st.smartsecurity.pojo.dto.ScreenStreamBaseInfoDTO;
import com.st.smartsecurity.pojo.vo.ScreenProductVO;
import com.st.smartsecurity.pojo.vo.ScreenStreamVO;

import java.util.List;

/**
 * 大屏接口
 * @author lhm
 */
public interface ScreenService {

    /**
     * 根据上中下游获取公司基本信息
     * @param screenStreamVO
     * @return
     */
    List<ScreenBaseDTO> listBaseInfoByStream(ScreenStreamVO screenStreamVO);

    /**
     * 根据上中下游查询公司产品、项目、需求
     * @param screenProductVO
     * @return
     */
    ScreenProductDTO listProductByStream(ScreenProductVO screenProductVO);

    /**
     * 获取公司产值
     * @return
     */
    CompanyScaleDTO getScale();
}
