package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 公司产品图片DTO
 * @author lhm
 */

@Data
@ApiModel(value = "公司产品图片DTO")
public class CompanyProductImgDTO {

    @ApiModelProperty(value = "公司产品图片id")
    private Long companyProductImgId;


    @ApiModelProperty(value = "公司产品图片")
    private String imgUrl;


}
