package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_other_demand`")
public class CompanyOtherDemand {
    @Id
    @Column(name = "`company_other_demand_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyOtherDemandId;

    /**
     * 需求名称
     */
    @Column(name = "`demand_name`")
    private String demandName;

    /**
     * 需求分类
     */
    @Column(name = "`demand_class`")
    private String demandClass;

    /**
     * 0:不保密；1:保密
     */
    @Column(name = "`is_encryption`")
    private Integer isEncryption;

    /**
     * 保密码
     */
    @Column(name = "`encryption_code`")
    private String encryptionCode;

    /**
     * 其他需求
     */
    @Column(name = "`other_demand`")
    private String otherDemand;

    /**
     * 所需资金
     */
    @Column(name = "`required_money`")
    private String requiredMoney;

    /**
     * 技术需求简述
     */
    @Column(name = "`technology_demand_info`")
    private String technologyDemandInfo;

    /**
     * 市场需求简述
     */
    @Column(name = "`market_demand_info`")
    private String marketDemandInfo;

    /**
     * 需求info
     */
    @Column(name = "`demand_info`")
    private String demandInfo;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`company_id`")
    private Long companyId;

    /**
     * 驳回原因
     */
    @Column(name = "`rejected`")
    private String rejected;

    /**
     * @return company_other_demand_id
     */
    public Long getCompanyOtherDemandId() {
        return companyOtherDemandId;
    }

    /**
     * @param companyOtherDemandId
     */
    public void setCompanyOtherDemandId(Long companyOtherDemandId) {
        this.companyOtherDemandId = companyOtherDemandId;
    }

    /**
     * 获取需求名称
     *
     * @return demand_name - 需求名称
     */
    public String getDemandName() {
        return demandName;
    }

    /**
     * 设置需求名称
     *
     * @param demandName 需求名称
     */
    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    /**
     * 获取需求分类
     *
     * @return demand_class - 需求分类
     */
    public String getDemandClass() {
        return demandClass;
    }

    /**
     * 设置需求分类
     *
     * @param demandClass 需求分类
     */
    public void setDemandClass(String demandClass) {
        this.demandClass = demandClass;
    }

    /**
     * 获取0:不保密；1:保密
     *
     * @return is_encryption - 0:不保密；1:保密
     */
    public Integer getIsEncryption() {
        return isEncryption;
    }

    /**
     * 设置0:不保密；1:保密
     *
     * @param isEncryption 0:不保密；1:保密
     */
    public void setIsEncryption(Integer isEncryption) {
        this.isEncryption = isEncryption;
    }

    /**
     * 获取保密码
     *
     * @return encryption_code - 保密码
     */
    public String getEncryptionCode() {
        return encryptionCode;
    }

    /**
     * 设置保密码
     *
     * @param encryptionCode 保密码
     */
    public void setEncryptionCode(String encryptionCode) {
        this.encryptionCode = encryptionCode;
    }

    /**
     * 获取其他需求
     *
     * @return other_demand - 其他需求
     */
    public String getOtherDemand() {
        return otherDemand;
    }

    /**
     * 设置其他需求
     *
     * @param otherDemand 其他需求
     */
    public void setOtherDemand(String otherDemand) {
        this.otherDemand = otherDemand;
    }

    /**
     * 获取所需资金
     *
     * @return required_money - 所需资金
     */
    public String getRequiredMoney() {
        return requiredMoney;
    }

    /**
     * 设置所需资金
     *
     * @param requiredMoney 所需资金
     */
    public void setRequiredMoney(String requiredMoney) {
        this.requiredMoney = requiredMoney;
    }

    /**
     * 获取技术需求简述
     *
     * @return technology_demand_info - 技术需求简述
     */
    public String getTechnologyDemandInfo() {
        return technologyDemandInfo;
    }

    /**
     * 设置技术需求简述
     *
     * @param technologyDemandInfo 技术需求简述
     */
    public void setTechnologyDemandInfo(String technologyDemandInfo) {
        this.technologyDemandInfo = technologyDemandInfo;
    }

    /**
     * 获取市场需求简述
     *
     * @return market_demand_info - 市场需求简述
     */
    public String getMarketDemandInfo() {
        return marketDemandInfo;
    }

    /**
     * 设置市场需求简述
     *
     * @param marketDemandInfo 市场需求简述
     */
    public void setMarketDemandInfo(String marketDemandInfo) {
        this.marketDemandInfo = marketDemandInfo;
    }

    /**
     * 获取需求info
     *
     * @return demand_info - 需求info
     */
    public String getDemandInfo() {
        return demandInfo;
    }

    /**
     * 设置需求info
     *
     * @param demandInfo 需求info
     */
    public void setDemandInfo(String demandInfo) {
        this.demandInfo = demandInfo;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取驳回原因
     *
     * @return rejected - 驳回原因
     */
    public String getRejected() {
        return rejected;
    }

    /**
     * 设置驳回原因
     *
     * @param rejected 驳回原因
     */
    public void setRejected(String rejected) {
        this.rejected = rejected;
    }
}