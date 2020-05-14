package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司需求分页查询参数
 * @author lhm
 */
@Data
@ApiModel(value = "公司需求分页查询参数")
public class CompanyDemandParamsVO extends PagerReqDto {

    @ApiModelProperty(value = "公司名称")
    String comName;
}
