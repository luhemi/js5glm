package com.st.smartsecurity.controller;

import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.CompanyScaleDTO;
import com.st.smartsecurity.pojo.dto.ScreenBaseDTO;
import com.st.smartsecurity.pojo.dto.ScreenProductDTO;
import com.st.smartsecurity.pojo.dto.ScreenStreamBaseInfoDTO;
import com.st.smartsecurity.pojo.vo.ScreenProductVO;
import com.st.smartsecurity.pojo.vo.ScreenStreamVO;
import com.st.smartsecurity.service.ScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 大屏接口
 * @author lhm
 */
@RestController
@RequestMapping("daPing")
@Api(value = "daPing", tags = "大屏接口", position = 1)
public class ScreenController {

    @Autowired
    ScreenService screenService;

    @PostMapping("listBaseInfoByStream")
    @ApiOperation(value = "通过上中下游查询公司基本信息")
    @PassToken
    public BaseResponse<List<ScreenBaseDTO>> listBaseInfoByStream(@RequestBody ScreenStreamVO screenStreamVO){
        Preconditions.checkArgument(screenStreamVO.getType() != null,"查询类型不可为空");
        return BaseResponse.success(screenService.listBaseInfoByStream(screenStreamVO));
    }

    @PostMapping("listProductByStream")
    @ApiOperation(value = "根据上中下游查询公司产品、项目、需求")
    @PassToken
    public BaseResponse<ScreenProductDTO> listProductByStream(@RequestBody ScreenProductVO screenProductVO){
        Preconditions.checkArgument(screenProductVO.getType() != null,"查询类型不可为空");
        Preconditions.checkArgument(screenProductVO.getProductType() != null,"查询产品类型不可为空");
        return BaseResponse.success(screenService.listProductByStream(screenProductVO));
    }

    @PostMapping("getScale")
    @ApiOperation(value = "获取公司产值")
    @PassToken
    public BaseResponse<CompanyScaleDTO> getScale(){
        return BaseResponse.success(screenService.getScale());
    }
}
