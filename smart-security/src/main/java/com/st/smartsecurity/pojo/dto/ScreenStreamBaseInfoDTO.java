package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 大屏公司基本信息DTO
 * @author lhm
 */
@Data
@ApiModel(value = "大屏公司基本信息DTO")
public class ScreenStreamBaseInfoDTO {

    @ApiModelProperty(value = "城市id")
    Integer id;

    @ApiModelProperty(value = "城市")
    String city;

    @ApiModelProperty(value = "数组")
    Integer mag;

    Long time;

    String felt;

    Integer tsunami;

    @ApiModelProperty(value = "公司列表")
    List<CompanyBaseInfoDTO> comList;
}
