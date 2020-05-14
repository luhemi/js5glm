package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司规模DTO
 * @author lhm
 */
@Data
@ApiModel(value = "公司规模DTO")
public class CompanyScaleDTO {

    @ApiModelProperty(value = "上游公司数")
    Integer upstreamCount;

    @ApiModelProperty(value = "中游公司数")
    Integer midstreamCount;

    @ApiModelProperty(value = "下游公司数")
    Integer downstreamCount;

    @ApiModelProperty(value = "上游公司产值")
    Float upstreamValueSum = 0.0f;

    @ApiModelProperty(value = "中游公司产值")
    Float midstreamValueSum = 0.0f;

    @ApiModelProperty(value = "下游公司产值")
    Float downstreamValueSum = 0.0f;


}
