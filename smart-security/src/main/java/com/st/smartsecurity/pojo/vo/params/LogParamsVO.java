package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "日志查询参数")
@Data
public class LogParamsVO extends PagerReqDto {
}
