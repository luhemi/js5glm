package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * 公司项目DTO
 * @author lhm
 */
@Data
@ApiModel(value = "公司项目DTO")
public class CompanyProjectDTO {

    @ApiModelProperty(value = "公司项目id")
    private Long companyProjectId;

    @ApiModelProperty(value = "所属行业")
    private List<Integer> industry;

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

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "图片列表")
    List<CompanyProjectImgDTO> imgList;


    /**
     * 是否保密 0:不保密; 1:保密
     */
    @ApiModelProperty(value = "是否保密")
    private Integer isEncryption;

    /**
     * 保密代码
     */
    @ApiModelProperty(value = "保密代码")
    private String encryptionCode;



    /**
     * 项目资金
     */
    @ApiModelProperty(value = "项目资金")
    private String projectMoney;



    @ApiModelProperty(value = "开始时间")
    private Date projectStart;

    @ApiModelProperty(value = "结束时间")
    private Date projectEnd;

    @ApiModelProperty(value = "驳回原因")
    String rejected;



}
