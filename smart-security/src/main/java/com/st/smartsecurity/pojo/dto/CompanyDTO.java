package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 公司DTO
 * @author lhm
 */
@Data
@ApiModel
public class CompanyDTO {

    @ApiModelProperty(value = "公司id")
    Long companyId;

/*    @ApiModelProperty(value = "经纬度")
    String park;*/

    @ApiModelProperty(value = "公司名称")
    private String comName;

    @ApiModelProperty(value = "用户名称")
    private String loginName;

    @ApiModelProperty(value = "用户密码")
    private String pwd;

    @ApiModelProperty(value = "公司代码")
    private String comCode;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 不是管理员:0 是管理员:1
     */
    @ApiModelProperty(value = "是否为管理员")
    private Integer isAdmin;
}
