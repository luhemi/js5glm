package com.st.smartsecurity.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * 公司基本信息接口
 * @author lhm
 */
@Data
@ApiModel
public class CompanyBaseInfoVO {

    @ApiModelProperty(value = "公司id")
    Long companyId;

    @ApiModelProperty("公司基本信息id,更新时传入")
    private Long companyBaseInfoId;

    /**
     * 单位名称
     */
    @ApiModelProperty("公司名称")
    private String comName;

    /**
     * 单位简称
     */
    @ApiModelProperty("单位简称")
    private String litcomname;

    /**
     * 企业资质（规上、高企、独角兽、瞪羚羊）分别是传id：1,2,3,4
     */
    @ApiModelProperty("企业资质")
    private Integer econkind;

    @ApiModelProperty("企业资质图片")
    List<String> econkindImgs;

    @ApiModelProperty("企业行业数组")
    List<String> industryList;

/*    @ApiModelProperty("企业资质图片1")
    private String econkindImg;

    @ApiModelProperty("企业资质图片2")
    private String econkindImg2;*/



    /**
     * 法人
     */
    @ApiModelProperty("法人")
    private String opername;

    /**
     * 注册资金（万元）
     */
    @ApiModelProperty("注册资金")
    private String registcapi;

    /**
     * 成立时间
     */
    @ApiModelProperty("成立时间")
    private Date startdate;

    /**
     * 注册地址
     */
    @ApiModelProperty("注册地址")
    private String address;

    /**
     * 是否上市
     1上市，0未上市
     */
    @ApiModelProperty("是否上市")
    private Integer isonline;

    /**
     * 上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     */
    @ApiModelProperty("上市交易所")
    private Integer exchange;

    /**
     * 其他交易所的名称
     */
    @ApiModelProperty("其他交易所的名称")
    private String exchangeValue;

    /**
     * 员工人数
     */
    @ApiModelProperty("员工人数")
    private Integer staffnum;


    /**
     * 主要项目（5G相关产品）
     */
    @ApiModelProperty("主要项目")
    private String mainproject;

    /**
     * 公司简介
     */
    @ApiModelProperty("单位简称")
    private String info;



    /**
     * 2019年收入总额（万元）
     */
    @ApiModelProperty("2019年收入总额")
    private Float lastincome;

    /**
     * 2018年收入总额（万元）
     */
    @ApiModelProperty("2018年收入总额")
    private Float oldincome;

    /**
     * 企业联系人
     */
    @ApiModelProperty("企业联系人")
    private String concatperson;

    /**
     * 邮件
     */
    @ApiModelProperty("邮件")
    private String email;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;

    /**
     * 股票代码
     */
    @ApiModelProperty("股票代码")
    private String stockCode;

    @ApiModelProperty("城市")
    private String city;



    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private String businessLicense;


    /**
     * 官网地址
     */
    @ApiModelProperty(value = "公司官网")
    private String websiteAddress;


}
