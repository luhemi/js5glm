package com.st.smartsecurity.controller;
import com.qs.common.core.response.BaseResponse;
import com.qs.common.core.util.FileUploadDto;
import com.qs.common.core.util.FileUploadUtil;
import com.st.smartsecurity.annotation.PassToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传接口
 * @author lhm
 */
@RestController
@RequestMapping("file")
@Api(value = "file", tags = "文件上传", position = 1)
public class FileUploadController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @PostMapping("upload")
    @ApiOperation(value="文件上传")
    @PassToken
    public BaseResponse upload(MultipartFile file){
        FileUploadDto fileUploadDto =  fileUploadUtil.uploadFile(file);
        return BaseResponse.success(fileUploadDto);
    }
}
