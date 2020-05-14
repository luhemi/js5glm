package com.st.smartsecurity.pojo.dto;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 公司产品DTO
 * @author lhm
 */
@Data
@ApiModel(value = "公司产品DTO")
public class CompanyProductDTO {

    @ApiModelProperty(value = "公司产品id")
    private Long companyProductId;

    @ApiModelProperty(value = "所属行业")
    private List<Integer> industry;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品介绍
     */
    @ApiModelProperty(value = "产品介绍")
    private String productIntroduce;

    /**
     * 产品关键字
     */
    @ApiModelProperty(value = "产品关键字")
    private String productKeyword;

    /**
     * 产品视频
     */
    @ApiModelProperty(value = "产品视频")
    private String productVideo;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createData;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "图片列表")
    List<CompanyProductImgDTO> imgList;

    /**
     * 产品参数
     */
    @ApiModelProperty(value = "产品参数")
    private String productParameters;

    /**
     * 产品销售额
     */
    @ApiModelProperty(value = "产品销售额")
    private String productSales;

}
