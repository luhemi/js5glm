package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 大屏公司产品DTO
 * @author lhm
 */
@Data
@ApiModel(value = "大屏公司产品DTO")
public class ScreenProductDTO {

    @ApiModelProperty(value = "公司产品列表")
    List<CompanyProductDTO> companyProductDTOList;

    @ApiModelProperty(value = "公司项目列表")
    List<CompanyProjectDTO> companyProjectDTOList;

    @ApiModelProperty(value = "公司产品需求列表")
    List<CompanyProductDemandDTO> companyProductDemandDTOList;

    @ApiModelProperty(value = "公司项目需求列表")
    List<CompanyProjectDemandDTO> companyProjectDemandDTOList;

    @ApiModelProperty(value = "公司其它需求列表")
    List<CompanyOtherDemandDTO> companyOtherDemandDTOList;
}
