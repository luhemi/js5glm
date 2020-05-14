package com.st.smartsecurity.pojo.po;

import javax.persistence.*;

@Table(name = "`company_industry`")
public class CompanyIndustry {
    @Id
    @Column(name = "`company_industry_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyIndustryId;

    @Column(name = "`company_id`")
    private Long companyId;

    @Column(name = "`industry`")
    private String industry;

    @Column(name = "`upstream`")
    private Integer upstream;

    @Column(name = "`midstream`")
    private Integer midstream;

    @Column(name = "`downstream`")
    private Integer downstream;

    @Column(name = "`state`")
    private String state;

    /**
     * @return company_industry_id
     */
    public Long getCompanyIndustryId() {
        return companyIndustryId;
    }

    /**
     * @param companyIndustryId
     */
    public void setCompanyIndustryId(Long companyIndustryId) {
        this.companyIndustryId = companyIndustryId;
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
     * @return upstream
     */
    public Integer getUpstream() {
        return upstream;
    }

    /**
     * @param upstream
     */
    public void setUpstream(Integer upstream) {
        this.upstream = upstream;
    }

    /**
     * @return midstream
     */
    public Integer getMidstream() {
        return midstream;
    }

    /**
     * @param midstream
     */
    public void setMidstream(Integer midstream) {
        this.midstream = midstream;
    }

    /**
     * @return downstream
     */
    public Integer getDownstream() {
        return downstream;
    }

    /**
     * @param downstream
     */
    public void setDownstream(Integer downstream) {
        this.downstream = downstream;
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
}