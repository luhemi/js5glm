package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_project`")
public class CompanyProject {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`industry`")
    private String industry;

    /**
     * 项目名称
     */
    @Column(name = "`project_name`")
    private String projectName;

    /**
     * 是否保密 0:不保密; 1:保密
     */
    @Column(name = "`is_encryption`")
    private Integer isEncryption;

    /**
     * 保密代码
     */
    @Column(name = "`encryption_code`")
    private String encryptionCode;

    /**
     * 项目介绍
     */
    @Column(name = "`project_introduce`")
    private String projectIntroduce;

    /**
     * 项目资金
     */
    @Column(name = "`project_money`")
    private String projectMoney;

    @Column(name = "`project_keyword`")
    private String projectKeyword;

    @Column(name = "`project_start`")
    private Date projectStart;

    @Column(name = "`project_end`")
    private Date projectEnd;

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
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取是否保密 0:不保密; 1:保密
     *
     * @return is_encryption - 是否保密 0:不保密; 1:保密
     */
    public Integer getIsEncryption() {
        return isEncryption;
    }

    /**
     * 设置是否保密 0:不保密; 1:保密
     *
     * @param isEncryption 是否保密 0:不保密; 1:保密
     */
    public void setIsEncryption(Integer isEncryption) {
        this.isEncryption = isEncryption;
    }

    /**
     * 获取保密代码
     *
     * @return encryption_code - 保密代码
     */
    public String getEncryptionCode() {
        return encryptionCode;
    }

    /**
     * 设置保密代码
     *
     * @param encryptionCode 保密代码
     */
    public void setEncryptionCode(String encryptionCode) {
        this.encryptionCode = encryptionCode;
    }

    /**
     * 获取项目介绍
     *
     * @return project_introduce - 项目介绍
     */
    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    /**
     * 设置项目介绍
     *
     * @param projectIntroduce 项目介绍
     */
    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce;
    }

    /**
     * 获取项目资金
     *
     * @return project_money - 项目资金
     */
    public String getProjectMoney() {
        return projectMoney;
    }

    /**
     * 设置项目资金
     *
     * @param projectMoney 项目资金
     */
    public void setProjectMoney(String projectMoney) {
        this.projectMoney = projectMoney;
    }

    /**
     * @return project_keyword
     */
    public String getProjectKeyword() {
        return projectKeyword;
    }

    /**
     * @param projectKeyword
     */
    public void setProjectKeyword(String projectKeyword) {
        this.projectKeyword = projectKeyword;
    }

    /**
     * @return project_start
     */
    public Date getProjectStart() {
        return projectStart;
    }

    /**
     * @param projectStart
     */
    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    /**
     * @return project_end
     */
    public Date getProjectEnd() {
        return projectEnd;
    }

    /**
     * @param projectEnd
     */
    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
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