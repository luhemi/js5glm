package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 大屏城市坐标DTO
 * @author lhm
 */
@Data
@ApiModel(value = "大屏城市坐标DTO")
public class ScreenCityCoordinatesDTO {

    String type;

    Double[] coordinates;
}
