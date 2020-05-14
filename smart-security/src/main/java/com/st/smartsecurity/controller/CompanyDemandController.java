package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.vo.CompanyOtherDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProductDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProjectDemandVO;
import com.st.smartsecurity.pojo.vo.params.CompanyDemandParamsVO;
import com.st.smartsecurity.service.CompanyDemandService;
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
 * 公司需求接口
 * @author lhm
 */
@RestController
@RequestMapping("companyDemand")
@Api(value = "companyDemand", tags = "公司需求接口", position = 1)
public class CompanyDemandController {

    @Autowired
    CompanyDemandService companyDemandService;
    @Autowired
    AddLogUtil addLogUtil;

    @PostMapping("addProductDemand")
    @ApiOperation(value = "新增产品需求")
    @PassToken
    public BaseResponse addProductDemand(@RequestBody CompanyProductDemandVO companyProductDemandVO){
        Preconditions.checkArgument(companyProductDemandVO.getCompanyId() != null, "公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProductDemandVO.getComName()), "公司名称不可为空");
        companyDemandService.addProductDemand(companyProductDemandVO);
        addLogUtil.addLog(companyProductDemandVO.getComName(), "增加了新产品需求");
        return BaseResponse.success();
    }

    @PostMapping("deleteProductDemand")
    @ApiOperation(value = "删除产品需求")
    @PassToken
    public BaseResponse deleteProductDemand(Long companyProductDemandId, String comName){
        Preconditions.checkArgument(companyProductDemandId != null, "公司产品需求id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName), "公司名称不可为空");
        companyDemandService.deleteProductDemand(companyProductDemandId, comName);
        addLogUtil.addLog(comName, "删除产品需求");
        return BaseResponse.success();
    }

    @PostMapping("getCompanyProductDemand")
    @ApiOperation(value = "获取产品需求详情")
    @PassToken
    public BaseResponse getCompanyProductDemand(Long companyProductDemandId){
        Preconditions.checkArgument(companyProductDemandId != null, "公司需求id不可为空");
        return BaseResponse.success(companyDemandService.getCompanyProductDemand(companyProductDemandId));
    }

    @PostMapping("listCompanyProductDemand")
    @ApiOperation(value = "获取产品需求列表")
    @PassToken
    public BaseResponse listCompanyProductDemand(@RequestBody CompanyDemandParamsVO companyDemandParamsVO){
        return BaseResponse.success(companyDemandService.listCompanyProductDemand(companyDemandParamsVO));
    }

    @PostMapping("addProjectDemand")
    @ApiOperation(value = "新增项目需求")
    @PassToken
    public BaseResponse addProjectDemand(@RequestBody CompanyProjectDemandVO companyProjectDemandVO){
        Preconditions.checkArgument(companyProjectDemandVO.getCompanyId() != null, "公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProjectDemandVO.getComName()), "公司名称不可为空");
        companyDemandService.addProjectDemand(companyProjectDemandVO);
        addLogUtil.addLog(companyProjectDemandVO.getComName(), "增加了新项目需求");
        return BaseResponse.success();
    }

    @PostMapping("deleteProjectDemand")
    @ApiOperation(value = "删除项目需求")
    @PassToken
    public BaseResponse deleteProjectDemand(Long companyProjectDemandId, String comName){
        Preconditions.checkArgument(companyProjectDemandId != null, "公司产品需求id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName), "公司名称不可为空");
        companyDemandService.deleteProjectDemand(companyProjectDemandId, comName);
        addLogUtil.addLog(comName, "删除项目需求");
        return BaseResponse.success();
    }

    @PostMapping("getCompanyProjectDemand")
    @ApiOperation(value = "获取项目需求详情")
    @PassToken
    public BaseResponse getCompanyProjectDemand(Long companyProjectDemandId){
        Preconditions.checkArgument(companyProjectDemandId != null, "公司需求id不可为空");
        return BaseResponse.success(companyDemandService.getCompanyProjectDemand(companyProjectDemandId));
    }

    @PostMapping("listCompanyProjectDemand")
    @ApiOperation(value = "获取项目需求列表")
    @PassToken
    public BaseResponse listCompanyProjectDemand(@RequestBody CompanyDemandParamsVO companyDemandParamsVO){
        return BaseResponse.success(companyDemandService.listCompanyProjectDemand(companyDemandParamsVO));
    }


    @PostMapping("addOtherDemand")
    @ApiOperation(value = "新增其它需求")
    @PassToken
    public BaseResponse addOtherDemand(@RequestBody CompanyOtherDemandVO companyOtherDemandVO){
        Preconditions.checkArgument(companyOtherDemandVO.getCompanyId() != null, "公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyOtherDemandVO.getComName()), "公司名称不可为空");
        companyDemandService.addOtherDemand(companyOtherDemandVO);
        addLogUtil.addLog(companyOtherDemandVO.getComName(), "增加了新其它需求");
        return BaseResponse.success();
    }

    @PostMapping("deleteOtherDemand")
    @ApiOperation(value = "删除其它需求")
    @PassToken
    public BaseResponse deleteOtherDemand(Long companyOtherDemandId, String comName){
        Preconditions.checkArgument(companyOtherDemandId != null, "公司其它需求id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName), "公司名称不可为空");
        companyDemandService.deleteOtherDemand(companyOtherDemandId, comName);
        addLogUtil.addLog(comName, "删除其它需求");
        return BaseResponse.success();
    }

    @PostMapping("getCompanyOtherDemand")
    @ApiOperation(value = "获取其它需求详情")
    @PassToken
    public BaseResponse getCompanyOtherDemand(Long companyOtherDemandId){
        Preconditions.checkArgument(companyOtherDemandId != null, "公司其它需求id不可为空");
        return BaseResponse.success(companyDemandService.getCompanyOtherDemand(companyOtherDemandId));
    }

    @PostMapping("listCompanyOtherDemand")
    @ApiOperation(value = "获取其它需求列表")
    @PassToken
    public BaseResponse listCompanyOtherDemand(@RequestBody CompanyDemandParamsVO companyDemandParamsVO){
        return BaseResponse.success(companyDemandService.listCompanyOtherDemand(companyDemandParamsVO));
    }
}
