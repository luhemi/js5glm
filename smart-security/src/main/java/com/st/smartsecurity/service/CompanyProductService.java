package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.CompanyProductDTO;
import com.st.smartsecurity.pojo.vo.CompanyProductVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProductParamsVO;

import java.util.List;

/**
 * 公司产品接口
 * @author lhm
 */
public interface CompanyProductService {

    /**
     * 增加公司产品
     * @param companyProductVO
     */
    void addProduct(CompanyProductVO companyProductVO);

    /**
     * 删除公司产品
     * @param companyProductId
     */
    void deleteProduct(Long companyProductId, String comName);

    /**
     * 修改公司产品
     * @param companyProductVO
     */
    void updateProduct(CompanyProductVO companyProductVO);

    /**
     * 获取公司产品详情
     * @param companyProductId
     * @return
     */
    CompanyProductDTO getProduct(Long companyProductId);

    /**
     * 通过公司id获取公司产品列表
     * @param companyProductParamsVO
     * @return
     */
    PageInfo listProduct(CompanyProductParamsVO companyProductParamsVO);

    /**
     * 获取公司产品列表，结果不分页
     * @return
     */
    List<CompanyProductDTO> listProductNotPage();

    /**
     * 审核公司产品
     * @param companyProductId
     * @param state
     * @param rejected
     */
    void checkCompanyProduct(Long companyProductId, String state, String rejected);
}
