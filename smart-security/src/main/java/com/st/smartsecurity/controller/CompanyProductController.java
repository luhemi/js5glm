package com.st.smartsecurity.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.CompanyProductDTO;
import com.st.smartsecurity.pojo.vo.CompanyProductVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProductParamsVO;
import com.st.smartsecurity.service.CompanyProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("companyProduct")
@Api(value = "companyProduct", tags = "公司产品接口", position = 1)
public class CompanyProductController {

    @Autowired
    CompanyProductService companyProductService;

    @PostMapping("addProduct")
    @ApiOperation(value = "增加公司产品")
    @PassToken
    public BaseResponse addProduct(@RequestBody CompanyProductVO companyProductVO){
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProductVO.getComName()),"公司名不可为空");
        Preconditions.checkArgument(companyProductVO.getCompanyId() != null,"公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProductVO.getProductName()),"产品名称不可为空");
        companyProductService.addProduct(companyProductVO);
        return BaseResponse.success();
    }

    @PostMapping("deleteProduct")
    @ApiOperation(value = "删除产品")
    @PassToken
    public BaseResponse deleteProduct(Long companyProductId, String comName){
        Preconditions.checkArgument(companyProductId != null,"公司产品id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName),"公司名不可为空");
        companyProductService.deleteProduct(companyProductId, comName);
        return BaseResponse.success();
    }

    @PostMapping("updateProduct")
    @ApiOperation(value = "修改公司产品")
    @PassToken
    public BaseResponse updateProduct(@RequestBody CompanyProductVO companyProductVO){
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProductVO.getComName()),"公司名不可为空");
        Preconditions.checkArgument(companyProductVO.getCompanyProductId() != null,"公司产品id不可为空");
        companyProductService.updateProduct(companyProductVO);
        return BaseResponse.success();
    }

    @PostMapping("getProduct")
    @ApiOperation(value = "获取产品详情")
    @PassToken
    public BaseResponse<CompanyProductDTO> getProduct(Long companyProductId){
        Preconditions.checkArgument(companyProductId != null,"公司产品id不可为空");
        return BaseResponse.success(companyProductService.getProduct(companyProductId));
    }

    @PostMapping("listProduct")
    @ApiOperation(value = "获取公司产品列表")
    @PassToken
    public BaseResponse<PageInfo<CompanyProductDTO>> listProduct(@RequestBody CompanyProductParamsVO companyProductParamsVO){
        return BaseResponse.success(companyProductService.listProduct(companyProductParamsVO));
    }

    @PostMapping("listProductNotPage")
    @ApiOperation(value = "获取公司产品列表,不分页")
    @PassToken
    public BaseResponse<List<CompanyProductDTO>> listProductNotPage(){
        return BaseResponse.success(companyProductService.listProductNotPage());
    }

    @PostMapping("checkCompanyProduct")
    @ApiOperation(value = "审核公司产品信息")
    @PassToken
    public BaseResponse checkCompanyProduct(Long companyProductId, String state, String rejected){
        companyProductService.checkCompanyProduct(companyProductId, state, rejected);
        return BaseResponse.success();
    }
}
