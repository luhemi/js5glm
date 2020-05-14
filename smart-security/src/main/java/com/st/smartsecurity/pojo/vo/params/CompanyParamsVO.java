package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司查询VO
 * @author lhm
 */
@Data
@ApiModel(value = "公司查询VO")
public class CompanyParamsVO extends PagerReqDto {

    @ApiModelProperty(value = "公司名称")
    String comName;
}
