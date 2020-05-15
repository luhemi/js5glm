package com.st.smartsecurity.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.CompanyProjectDTO;
import com.st.smartsecurity.pojo.vo.CompanyProjectVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProjectParamsVO;
import com.st.smartsecurity.service.CompanyProjectService;
import com.st.smartsecurity.util.AddLogUtil;
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
@RequestMapping("companyProject")
@Api(value = "companyProject", tags = "公司项目接口", position = 1)
public class CompanyProjectController {

    @Autowired
    CompanyProjectService companyProjectService;
    @Autowired
    AddLogUtil addLogUtil;

    @PostMapping("addProject")
    @ApiOperation(value = "增加公司项目")
    @PassToken
    public BaseResponse addProject(@RequestBody CompanyProjectVO companyProjectVO){
        Preconditions.checkArgument(companyProjectVO.getCompanyId() != null,"公司id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProjectVO.getComName()),"公司名称不可为空");
        Preconditions.checkArgument(companyProjectVO.getIsEncryption() != null,"请选择是否为保密项目");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProjectVO.getProjectName()),"项目名称不可为空");
        companyProjectService.addProject(companyProjectVO);
        addLogUtil.addLog(companyProjectVO.getComName(), "增加了公司项目");
        return BaseResponse.success();
    }

    @PostMapping("deleteProject")
    @ApiOperation(value = "删除公司项目")
    @PassToken
    public BaseResponse deleteProject(Long companyProjectId, String comName){
        Preconditions.checkArgument(companyProjectId != null,"公司项目id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(comName),"公司名称不可为空");
        companyProjectService.deleteProject(companyProjectId, comName);
        addLogUtil.addLog(comName, "删除了公司项目");
        return BaseResponse.success();
    }

    @PostMapping("updateProject")
    @ApiOperation(value = "修改公司项目")
    @PassToken
    public BaseResponse updateProject(@RequestBody CompanyProjectVO companyProjectVO){
        Preconditions.checkArgument(companyProjectVO.getCompanyProjectId() != null,"公司项目id不可为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(companyProjectVO.getComName()),"公司名称不可为空");
        companyProjectService.updateProject(companyProjectVO);
        addLogUtil.addLog(companyProjectVO.getComName(), "修改了公司项目");
        return BaseResponse.success();
    }

    @PostMapping("getCompanyProject")
    @ApiOperation(value = "获取公司项目详情")
    @PassToken
    public BaseResponse<CompanyProjectDTO> getCompanyProject(Long companyProjectId){
        Preconditions.checkArgument( companyProjectId!= null,"公司项目id不可为空");
        return BaseResponse.success(companyProjectService.getCompanyProject(companyProjectId));
    }

    @PostMapping("listCompanyProject")
    @ApiOperation(value = "获取公司项目列表")
    @PassToken
    public BaseResponse<PageInfo<CompanyProjectDTO>> listCompanyProject(@RequestBody CompanyProjectParamsVO companyProjectParamsVO){
        return BaseResponse.success(companyProjectService.listCompanyProject(companyProjectParamsVO));
    }

    @PostMapping("listProject")
    @ApiOperation(value = "获取公司项目列表,不分页")
    @PassToken
    public BaseResponse<List<CompanyProjectDTO>> listProject(){
        return BaseResponse.success(companyProjectService.listProject());
    }

    @PostMapping("checkCompanyProject")
    @ApiOperation(value = "审核公司项目信息")
    @PassToken
    public BaseResponse checkCompanyProject(Long companyProjectId, String state, String rejected){
        companyProjectService.checkCompanyProject(companyProjectId, state, rejected);
        return BaseResponse.success();
    }
}
