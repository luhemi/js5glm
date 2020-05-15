package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 公司项目接口
 * @author lhm
 */
@Data
@ApiModel(value = "公司项目接口")
public class CompanyProjectVO {

    @ApiModelProperty(value = "公司项目id")
    private Long companyProjectId;


    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目介绍
     */
    @ApiModelProperty(value = "项目介绍")
    private String projectIntroduce;

    @ApiModelProperty(value = "项目关键字")
    private String projectKeyword;

    /**
     * 是否落地 1:已落地; 2:未落地; 3:落地过程中
     */
    @ApiModelProperty(value = "是否落地")
    private Integer isactualmake;


    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty("公司名称")
    private String comName;

//    @ApiModelProperty("图片列表")
//    List<String> imgList;


    /**
     * 是否保密 0:不保密; 1:保密
     */
    @ApiModelProperty("是否保密")
    private Integer isEncryption;

    /**
     * 项目资金
     */
    @ApiModelProperty("项目资金")
    private String projectMoney;

    @ApiModelProperty("开始时间")
    private Date projectStart;

    @ApiModelProperty("结束时间")
    private Date projectEnd;




}
