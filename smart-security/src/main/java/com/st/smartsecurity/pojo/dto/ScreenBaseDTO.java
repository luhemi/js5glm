package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 用于封装外层数据DTO
 * @author
 */
@Data
@ApiModel(value = "封装DTO")
public class ScreenBaseDTO {

    String type;

    ScreenStreamBaseInfoDTO properties;

    ScreenCityCoordinatesDTO geometry;
}
