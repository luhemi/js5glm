package com.st.smartsecurity.controller;

import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.vo.params.LogParamsVO;
import com.st.smartsecurity.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
@Api(value = "log", tags = "日志接口", position = 1)
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping("listLog")
    @ApiOperation("日志列表")
    @PassToken
    public BaseResponse listLog(LogParamsVO logParamsVO){
        return BaseResponse.success(logService.listLog(logParamsVO));
    }
}
