package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "日志参数")
public class LogDTO {

    @ApiModelProperty(value = "日志id")
    private Long logId;

    /**
     * 登录人
     */
    @ApiModelProperty(value = "登录人")
    private String loginName;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private Date createDate;

    /**
     * 操作内容
     */
    @ApiModelProperty(value = "操作内容")
    private String content;
}
