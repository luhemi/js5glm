package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司项目图片DTO
 * @author lhm
 */
@Data
@ApiModel(value = "公司项目图片DTO")
public class CompanyProjectImgDTO {

    @ApiModelProperty(value = "公司项目图片id")
    private Long companyProjectImgId;


    @ApiModelProperty(value = "公司产品图片")
    private String imgUrl;
}
