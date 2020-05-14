package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.st.smartsecurity.pojo.dto.CompanyProjectDTO;
import com.st.smartsecurity.pojo.vo.CompanyProjectVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProjectParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 公司项目接口
 * @author lhm
 */
public interface CompanyProjectService {

    /**
     * 增加公司项目
     * @param companyProjectVO
     */
    void addProject(CompanyProjectVO companyProjectVO);

    /**
     * 删除公司项目
     * @param companyProjectId
     * @param comName
     */
    void deleteProject(Long companyProjectId, String comName);

    /**
     * 获取公司项目
     * @param companyProjectId
     * @return
     */
    CompanyProjectDTO getCompanyProject(Long companyProjectId);

    /**
     * 获取公司项目列表
     * @param companyProjectParamsVO
     * @return
     */
    PageInfo listCompanyProject(CompanyProjectParamsVO companyProjectParamsVO);

    /**
     * 获取公司项目列表，不分页
     * @return
     */
    List<CompanyProjectDTO> listProject();
}
