package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.dto.CompanyDTO;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;

import java.util.List;

/**
 * 公司基本信息接口
 * @author lhm
 */
public interface CompanyBaseInfoService {

    /**
     * 增加公司基本信息
     */
    void addBaseInfo(CompanyBaseInfoVO companyBaseInfoVO);

    /**
     * 更新公司基本信息
     * @param companyBaseInfoVO
     */
    void updateBaseInfo(CompanyBaseInfoVO companyBaseInfoVO);

    /**
     * 查询公司基本信息
     * @param companyId
     * @return
     */
    CompanyBaseInfoDTO getBaseInfo(Long companyId);

    /**
     * 增加公司分组
     * @param companyBaseInfoVO
     */
    void addIndustry(CompanyBaseInfoVO companyBaseInfoVO);

    /**
     * 获取字符串数组
     * @param str
     * @return
     */
    List<Integer> getMiddleStringArray(String str);

    /**
     * 获取公司列表
     * @param companyParamsVO
     * @return
     */
    PageInfo listCompany(CompanyParamsVO companyParamsVO);

    /**
     * 修改公司是否为管理员身份
     * @param companyId
     * @param isAdmin
     */
    void updateCompanyAdmin(Long companyId, Integer isAdmin);

    /**
     * 通过上中下游查询公司id
     * @param streamType
     * @return
     */
    List<Long> listCompanyIdByStream(int streamType);

    /**
     * 通过公司名称模糊查询公司id列表
     * @param companyName
     * @return
     */
    List<Long> listCompanyIdByName(String companyName);

    /**
     * 删除公司
     * @param companyId
     */
    void deleteCompany(Long companyId);
}
