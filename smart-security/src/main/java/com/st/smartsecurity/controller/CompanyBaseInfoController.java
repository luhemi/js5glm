package com.st.smartsecurity.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.po.Company;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import com.st.smartsecurity.util.AddLogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司基本信息接口
 * @author lhm
 */
@RestController
@RequestMapping("companyBaseInfo")
@Api(value = "companyBaseInfo", tags = "公司基本信息接口", position = 1)
public class CompanyBaseInfoController {

    @Autowired
    CompanyBaseInfoService companyBaseInfoService;
    @Autowired
    AddLogUtil addLogUtil;

    @PostMapping("addBaseInfo")
    @ApiOperation(value = "增加公司基本信息")
    @PassToken
    public BaseResponse addBaseInfo(@RequestBody CompanyBaseInfoVO companyBaseInfoVO){
        Preconditions.checkArgument(companyBaseInfoVO.getCompanyId() != null,"公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyBaseInfoVO.getComName()),"公司名不可为空");
        companyBaseInfoService.addBaseInfo(companyBaseInfoVO);
        addLogUtil.addLog(companyBaseInfoVO.getComName(), "添加公司基本信息");
        return BaseResponse.success();
    }

    @PostMapping("updateBaseInfo")
    @ApiOperation(value = "修改公司基本信息")
    @PassToken
    public BaseResponse updateBaseInfo(@RequestBody CompanyBaseInfoVO companyBaseInfoVO){
        Preconditions.checkArgument(companyBaseInfoVO.getCompanyBaseInfoId() != null,"公司基本信息id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyBaseInfoVO.getComName()),"公司名称不可为空");
        companyBaseInfoService.updateBaseInfo(companyBaseInfoVO);
        addLogUtil.addLog(companyBaseInfoVO.getComName(), "修改了公司基本信息");
        return BaseResponse.success();
    }

    @PostMapping("getBaseInfo")
    @ApiOperation(value = "获取公司基本信息")
    @PassToken
    public BaseResponse<CompanyBaseInfoDTO> getBaseInfo(Long companyId){
        Preconditions.checkArgument(companyId  != null,"公司id不可为空");
        return BaseResponse.success(companyBaseInfoService.getBaseInfo(companyId));
    }

    @PostMapping("listCompany")
    @ApiOperation(value = "获取公司列表")
    @PassToken
    public BaseResponse<PageInfo> listCompany(@RequestBody CompanyParamsVO companyParamsVO){
        return BaseResponse.success(companyBaseInfoService.listCompany(companyParamsVO));
    }

    @PostMapping("updateCompanyAdmin")
    @ApiOperation(value = "修改公司是否为管理员身份")
    @PassToken
    public BaseResponse updateCompanyAdmin(Long companyId, Integer isAdmin, String comName){
        Preconditions.checkArgument(companyId != null, "公司id不可为空");
        Preconditions.checkArgument(isAdmin!= null,"修改类型不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName),"登录公司名不可为空");
        companyBaseInfoService.updateCompanyAdmin(companyId, isAdmin, comName);
        addLogUtil.addLog(comName, "修改管理员身份");
        return BaseResponse.success();
    }

    @PostMapping("deleteCompany")
    @ApiOperation(value = "删除公司")
    @PassToken
    public BaseResponse deleteCompany(Long companyId, String comName){
        Preconditions.checkArgument(companyId != null, "公司id不可为空");
        companyBaseInfoService.deleteCompany(companyId);
        addLogUtil.addLog(comName, "删除公司");
        return BaseResponse.success();
    }

    @PostMapping("checkCompanyBaseInfo")
    @ApiOperation(value = "审核公司基本信息")
    @PassToken
    public BaseResponse checkCompanyBaseInfo(Long companyBaseInfoId, String state, String rejected){
        companyBaseInfoService.checkCompanyBaseInfo(companyBaseInfoId, state, rejected);
        return BaseResponse.success();
    }
}
