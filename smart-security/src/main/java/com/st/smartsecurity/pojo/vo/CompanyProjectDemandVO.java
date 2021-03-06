package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司需求VO
 * @author lhm
 */
@Data
@ApiModel(value = "公司项目需求VO")
public class CompanyProjectDemandVO {

    @ApiModelProperty(value = "项目需求id")
    Long companyProjectDemandId;

    /**
     * 需求分类
     */
    @ApiModelProperty(value = "需求分类")
    private String demandClass;


    /**
     * 附件地址
     */
    @ApiModelProperty(value = "附件地址")
    private String attachmentUrl;

    @ApiModelProperty("公司名称")
    private String comName;

    @ApiModelProperty("公司id")
    Long companyId;


//    @ApiModelProperty("公司项目需求id")
//    Long companyProjectDemandId;

    /**
     * 公司项目id
     */
    @ApiModelProperty("公司项目id")
    private Long companyProjectId;



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
    @ApiModelProperty("市场需求简述")
    private String marketDemandInfo;

    /**
     * 需求info
     */
    @ApiModelProperty("需求info")
    private String demandInfo;

}
