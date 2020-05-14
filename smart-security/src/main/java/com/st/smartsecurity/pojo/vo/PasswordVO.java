package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改密码VO
 * @author lhm
 */
@Data
@ApiModel(value = "修改密码VO")
public class PasswordVO {

    @ApiModelProperty(value = "登录名称")
    private String loginName;

    @ApiModelProperty(value = "老密码")
    private String pwd;

    @ApiModelProperty(value = "新密码")
    private String newPwd;

    @ApiModelProperty(value = "统一信用代码")
    private String comCode;
}
