package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.vo.CompanyVO;
import com.st.smartsecurity.pojo.vo.PasswordVO;
import com.st.smartsecurity.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录注册接口
 * @author lhm
 */
@RestController
@RequestMapping("user")
@Api(value = "user", tags = "登录注册接口", position = 1)
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("regist")
    @ApiOperation("用户注册接口")
    @PassToken
    public BaseResponse regist(@RequestBody CompanyVO companyVO){
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getComCode()),"信用代码不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getComName()),"公司名称不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getLoginName()),"用户名不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getPwd()),"密码不可为空");
        loginService.register(companyVO);
        return BaseResponse.success();
    }

    @PostMapping("login")
    @ApiOperation("用户登录接口")
    @PassToken
    public BaseResponse login(@RequestBody CompanyVO companyVO){
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getLoginName()),"用户名不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(companyVO.getPwd()),"密码不可为空");
        return BaseResponse.success(loginService.login(companyVO.getLoginName(), companyVO.getPwd()));
    }

    @PostMapping("reset")
    @ApiOperation("重置密码")
    @PassToken
    public BaseResponse reset(String comCode){
        Preconditions.checkArgument(StringUtils.isNotEmpty(comCode),"信用代码不可为空");
        return BaseResponse.success(loginService.reset(comCode));
    }

    @PostMapping("updatePwd")
    @ApiOperation("修改密码")
    @PassToken
    public BaseResponse updatePwd(PasswordVO passwordVO){
        Preconditions.checkArgument(StringUtils.isNotEmpty(passwordVO.getComCode()),"信用代码不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(passwordVO.getLoginName()),"登录名不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(passwordVO.getNewPwd()),"新密码不可为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(passwordVO.getPwd()),"老密码不可为空");
        loginService.updatePwd(passwordVO);
        return BaseResponse.success();
    }
}
