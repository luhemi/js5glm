package com.st.smartsecurity.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 公司需求DTO
 * @author lhm
 */
@Data
@ApiModel(value = "公司项目需求DTO")
public class CompanyProjectDemandDTO {

    @ApiModelProperty(value = "公司项目需求id")
    Long companyProjectDemandId;

    @ApiModelProperty(value = "公司项目id")
    Long companyProjectId;

    @ApiModelProperty(value = "公司项目名称")
    String companyProjectName;

    @ApiModelProperty(value = "所属分组")
    private List<Integer> industry;

    /**
     * 需求分类
     */
    @ApiModelProperty(value = "需求分类")
    private List<Integer> demandClass;


    /**
     * 附件地址
     */
    @ApiModelProperty(value = "附件地址")
    private String attachmentUrl;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty("公司id")
    Long companyId;



    /**
     * 0:不保密；1:保密
     */
    @ApiModelProperty("是否保密")
    private Integer isEncryption;

    /**
     * 保密码
     */
    @ApiModelProperty("保密码")
    private String encryptionCode;

    /**
     * 其他需求
     */
    @ApiModelProperty("其他需求")
    private String otherDemand;

    /**
     * 所需资金
     */
    @ApiModelProperty("所需资金")
    private String requiredMoney;

    /**
     * 技术需求简述
     */
    @ApiModelProperty("技术需求简述")
    private String technologyDemandInfo;

    /**
     * 市场需求简述
     */
    @ApiModelProperty("需求项目")
    private String marketDemandInfo;

    /**
     * 需求info
     */
    @ApiModelProperty("需求info")
    private String demandInfo;
}


