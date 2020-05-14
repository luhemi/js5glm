package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 大屏根据上中下游查询产品VO
 * @author lhm
 */
@Data
@ApiModel(value = "大屏根据上中下游查询产品VO")
public class ScreenProductVO {

    @ApiModelProperty(value = "查询类型，上游：1、中游2、下游：3、全部：4")
    Integer type;

/*    @ApiModelProperty(value = "查询值，上中下游具体值")
    Integer value;*/

    @ApiModelProperty(value = "查询产品类型，产品：1、项目：2、需求：3")
    Integer productType;

    @ApiModelProperty(value = "产品名称")
    String productName;

    @ApiModelProperty(value = "公司名称")
    String companyName;
}
