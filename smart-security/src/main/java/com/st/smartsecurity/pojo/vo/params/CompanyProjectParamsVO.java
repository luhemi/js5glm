package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司分页项目查询参数
 * @author lhm
 */
@Data
@ApiModel(value = "公司分页项目查询参数")
public class CompanyProjectParamsVO extends PagerReqDto {

    @ApiModelProperty(value = "公司id")
    Long companyId;
}
