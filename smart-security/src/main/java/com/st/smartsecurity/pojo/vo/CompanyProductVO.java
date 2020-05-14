package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * 公司产品VO
 * @author lhm
 */
@Data
@ApiModel(value = "公司产品VO")
public class CompanyProductVO {

    @ApiModelProperty(value = "公司产品id")
    private Long companyProductId;

    @ApiModelProperty(value = "所属行业")
    private String industry;

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

    @ApiModelProperty("公司名称")
    private String comName;

    @ApiModelProperty("公司id")
    Long companyId;

    @ApiModelProperty("图片列表")
    List<String> imgList;


    /**
     * 产品参数
     */
    @ApiModelProperty("产品参数")
    private String productParameters;

    /**
     * 产品销售额
     */
    @ApiModelProperty("产品销售额")
    private String productSales;


}
