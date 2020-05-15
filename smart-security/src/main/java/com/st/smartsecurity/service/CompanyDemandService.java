package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.CompanyOtherDemandDTO;
import com.st.smartsecurity.pojo.dto.CompanyProductDemandDTO;
import com.st.smartsecurity.pojo.dto.CompanyProjectDemandDTO;
import com.st.smartsecurity.pojo.po.CompanyOtherDemand;
import com.st.smartsecurity.pojo.vo.CompanyOtherDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProductDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProductVO;
import com.st.smartsecurity.pojo.vo.CompanyProjectDemandVO;
import com.st.smartsecurity.pojo.vo.params.CompanyDemandParamsVO;

/**
 * 公司需求接口
 * @author lhm
 */
public interface CompanyDemandService {

    //---------------------------------------------产品需求------------------------------------------------------------

    /**
     * 新增产品需求
     * @param companyProductDemandVO
     */
    void addProductDemand(CompanyProductDemandVO companyProductDemandVO);

    /**
     * 删除产品需求
     * @param companyProductDemandId
     * @param comName
     */
    void deleteProductDemand(Long companyProductDemandId, String comName);

    /**
     * 修改产品需求
     * @param companyProductDemandVO
     */
    void updateProductDemand(CompanyProductDemandVO companyProductDemandVO);

    /**
     * 获取产品需求详情
     * @param companyProductDemandId
     * @return
     */
    CompanyProductDemandDTO getCompanyProductDemand(Long companyProductDemandId);

    /**
     * 获取产品需求列表
     * @param companyDemandParamsVO
     * @return
     */
    PageInfo listCompanyProductDemand(CompanyDemandParamsVO companyDemandParamsVO);

    /**
     * 审核产品需求
     * @param companyProductDemandId
     * @param state
     * @param rejected
     */
    void checkCompanyProductDemand(Long companyProductDemandId, String state, String rejected);


    //---------------------------------------------项目需求------------------------------------------------------------

    /**
     * 新增项目需求
     * @param companyProjectDemandVO
     */
    void addProjectDemand(CompanyProjectDemandVO companyProjectDemandVO);

    /**
     * 删除项目需求
     * @param companyProjectDemandId
     * @param comName
     */
    void deleteProjectDemand(Long companyProjectDemandId, String comName);

    /**
     * 修改项目需求
     * @param companyProjectDemandVO
     */
    void updateProjectDemand(CompanyProjectDemandVO companyProjectDemandVO);

    /**
     * 获取项目需求详情
     * @param companyProjectDemandId
     * @return
     */
    CompanyProjectDemandDTO getCompanyProjectDemand(Long companyProjectDemandId);

    /**
     * 获取项目需求列表
     * @param companyDemandParamsVO
     * @return
     */
    PageInfo listCompanyProjectDemand(CompanyDemandParamsVO companyDemandParamsVO);

    /**
     * 审核公司项目需求信息
     * @param companyProjectDemandId
     * @param state
     * @param rejected
     */
    void checkCompanyProjectDemand(Long companyProjectDemandId, String state, String rejected);


    //---------------------------------------------其它需求------------------------------------------------------------

    /**
     * 新增其它需求
     * @param companyOtherDemandVO
     */
    void addOtherDemand(CompanyOtherDemandVO companyOtherDemandVO);

    /**
     * 删除其它需求
     * @param companyOtherDemandId
     * @param comName
     */
    void deleteOtherDemand(Long companyOtherDemandId, String comName);

    /**
     * 修改其它需求
     * @param companyOtherDemandVO
     */
    void updateOtherDemand(CompanyOtherDemandVO companyOtherDemandVO);

    /**
     * 获取其它需求详情
     * @param companyOtherDemandId
     * @return
     */
    CompanyOtherDemandDTO getCompanyOtherDemand(Long companyOtherDemandId);

    /**
     * 获取其它需求列表
     * @param companyDemandParamsVO
     * @return
     */
    PageInfo listCompanyOtherDemand(CompanyDemandParamsVO companyDemandParamsVO);

    /**
     * 审核公司其它需求信息
     * @param companyOtherDemandId
     * @param state
     * @param rejected
     */
    void checkCompanyOtherDemand(Long companyOtherDemandId, String state, String rejected);
}
