package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 大屏根据上中下游查询VO
 * @author lhm
 */
@Data
@ApiModel(value = "大屏根据上中下游查询VO")
public class ScreenStreamVO {

    @ApiModelProperty(value = "查询类型，上游：1、中游2、下游：3、全部：4")
    Integer type;

/*    @ApiModelProperty(value = "查询值，上中下游具体值")
    Integer value;*/

}
