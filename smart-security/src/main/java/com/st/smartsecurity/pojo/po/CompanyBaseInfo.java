package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_base_info`")
public class CompanyBaseInfo {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 单位名称
     */
    @Column(name = "`com_name`")
    private String comName;

    /**
     * 单位简称
     */
    @Column(name = "`litComName`")
    private String litcomname;

    /**
     * 企业资质（规上、高企、瞪羚羊）分别是传id：1,2,3
     */
    @Column(name = "`econkind`")
    private Integer econkind;

    @Column(name = "`econkind_img`")
    private String econkindImg;

    @Column(name = "`econkind_img2`")
    private String econkindImg2;

    /**
     * 营业执照
     */
    @Column(name = "`business_license`")
    private String businessLicense;

    /**
     * 法人
     */
    @Column(name = "`operName`")
    private String opername;

    /**
     * 注册资金（万元）
     */
    @Column(name = "`registCapi`")
    private String registcapi;

    /**
     * 成立时间
     */
    @Column(name = "`startDate`")
    private Date startdate;

    /**
     * 注册地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 是否上市
1上市，0未上市
     */
    @Column(name = "`isOnline`")
    private Integer isonline;

    /**
     * 官网地址
     */
    @Column(name = "`website_address`")
    private String websiteAddress;

    /**
     * 上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     */
    @Column(name = "`exchange`")
    private Integer exchange;

    /**
     * 其他交易所的名称
     */
    @Column(name = "`exchange_value`")
    private String exchangeValue;

    /**
     * 员工人数
     */
    @Column(name = "`staffNum`")
    private Integer staffnum;

    /**
     * 所属行业（数组）
     */
    @Column(name = "`industry`")
    private String industry;

    /**
     * 公司简介
     */
    @Column(name = "`info`")
    private String info;

    /**
     * 2019年收入总额（万元）
     */
    @Column(name = "`lastIncome`")
    private Float lastincome;

    /**
     * 2018年收入总额（万元）
     */
    @Column(name = "`oldIncome`")
    private Float oldincome;

    /**
     * 企业联系人
     */
    @Column(name = "`concatPerson`")
    private String concatperson;

    /**
     * 邮件
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 联系方式
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * 股票代码
     */
    @Column(name = "`stock_code`")
    private String stockCode;

    @Column(name = "`company_id`")
    private Long companyId;

    /**
     * 城市
     */
    @Column(name = "`city`")
    private String city;

    /**
     * 上游
     */
    @Column(name = "`upstream`")
    private Integer upstream;

    /**
     * 中游
     */
    @Column(name = "`midstream`")
    private Integer midstream;

    /**
     * 下游
     */
    @Column(name = "`downstream`")
    private Integer downstream;

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
     * 获取单位名称
     *
     * @return com_name - 单位名称
     */
    public String getComName() {
        return comName;
    }

    /**
     * 设置单位名称
     *
     * @param comName 单位名称
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * 获取单位简称
     *
     * @return litComName - 单位简称
     */
    public String getLitcomname() {
        return litcomname;
    }

    /**
     * 设置单位简称
     *
     * @param litcomname 单位简称
     */
    public void setLitcomname(String litcomname) {
        this.litcomname = litcomname;
    }

    /**
     * 获取企业资质（规上、高企、瞪羚羊）分别是传id：1,2,3
     *
     * @return econkind - 企业资质（规上、高企、瞪羚羊）分别是传id：1,2,3
     */
    public Integer getEconkind() {
        return econkind;
    }

    /**
     * 设置企业资质（规上、高企、瞪羚羊）分别是传id：1,2,3
     *
     * @param econkind 企业资质（规上、高企、瞪羚羊）分别是传id：1,2,3
     */
    public void setEconkind(Integer econkind) {
        this.econkind = econkind;
    }

    /**
     * @return econkind_img
     */
    public String getEconkindImg() {
        return econkindImg;
    }

    /**
     * @param econkindImg
     */
    public void setEconkindImg(String econkindImg) {
        this.econkindImg = econkindImg;
    }

    /**
     * @return econkind_img2
     */
    public String getEconkindImg2() {
        return econkindImg2;
    }

    /**
     * @param econkindImg2
     */
    public void setEconkindImg2(String econkindImg2) {
        this.econkindImg2 = econkindImg2;
    }

    /**
     * 获取营业执照
     *
     * @return business_license - 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicense 营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 获取法人
     *
     * @return operName - 法人
     */
    public String getOpername() {
        return opername;
    }

    /**
     * 设置法人
     *
     * @param opername 法人
     */
    public void setOpername(String opername) {
        this.opername = opername;
    }

    /**
     * 获取注册资金（万元）
     *
     * @return registCapi - 注册资金（万元）
     */
    public String getRegistcapi() {
        return registcapi;
    }

    /**
     * 设置注册资金（万元）
     *
     * @param registcapi 注册资金（万元）
     */
    public void setRegistcapi(String registcapi) {
        this.registcapi = registcapi;
    }

    /**
     * 获取成立时间
     *
     * @return startDate - 成立时间
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * 设置成立时间
     *
     * @param startdate 成立时间
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * 获取注册地址
     *
     * @return address - 注册地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置注册地址
     *
     * @param address 注册地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取是否上市
1上市，0未上市
     *
     * @return isOnline - 是否上市
1上市，0未上市
     */
    public Integer getIsonline() {
        return isonline;
    }

    /**
     * 设置是否上市
1上市，0未上市
     *
     * @param isonline 是否上市
1上市，0未上市
     */
    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    /**
     * 获取官网地址
     *
     * @return website_address - 官网地址
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * 设置官网地址
     *
     * @param websiteAddress 官网地址
     */
    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    /**
     * 获取上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     *
     * @return exchange - 上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     */
    public Integer getExchange() {
        return exchange;
    }

    /**
     * 设置上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     *
     * @param exchange 上市交易所;  上海:1、深圳:2、香港:3、纽约:4、伦敦:5、其他6
     */
    public void setExchange(Integer exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取其他交易所的名称
     *
     * @return exchange_value - 其他交易所的名称
     */
    public String getExchangeValue() {
        return exchangeValue;
    }

    /**
     * 设置其他交易所的名称
     *
     * @param exchangeValue 其他交易所的名称
     */
    public void setExchangeValue(String exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    /**
     * 获取员工人数
     *
     * @return staffNum - 员工人数
     */
    public Integer getStaffnum() {
        return staffnum;
    }

    /**
     * 设置员工人数
     *
     * @param staffnum 员工人数
     */
    public void setStaffnum(Integer staffnum) {
        this.staffnum = staffnum;
    }

    /**
     * 获取所属行业（数组）
     *
     * @return industry - 所属行业（数组）
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业（数组）
     *
     * @param industry 所属行业（数组）
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取公司简介
     *
     * @return info - 公司简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置公司简介
     *
     * @param info 公司简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取2019年收入总额（万元）
     *
     * @return lastIncome - 2019年收入总额（万元）
     */
    public Float getLastincome() {
        return lastincome;
    }

    /**
     * 设置2019年收入总额（万元）
     *
     * @param lastincome 2019年收入总额（万元）
     */
    public void setLastincome(Float lastincome) {
        this.lastincome = lastincome;
    }

    /**
     * 获取2018年收入总额（万元）
     *
     * @return oldIncome - 2018年收入总额（万元）
     */
    public Float getOldincome() {
        return oldincome;
    }

    /**
     * 设置2018年收入总额（万元）
     *
     * @param oldincome 2018年收入总额（万元）
     */
    public void setOldincome(Float oldincome) {
        this.oldincome = oldincome;
    }

    /**
     * 获取企业联系人
     *
     * @return concatPerson - 企业联系人
     */
    public String getConcatperson() {
        return concatperson;
    }

    /**
     * 设置企业联系人
     *
     * @param concatperson 企业联系人
     */
    public void setConcatperson(String concatperson) {
        this.concatperson = concatperson;
    }

    /**
     * 获取邮件
     *
     * @return email - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系方式
     *
     * @return phone - 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系方式
     *
     * @param phone 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取股票代码
     *
     * @return stock_code - 股票代码
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * 设置股票代码
     *
     * @param stockCode 股票代码
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取上游
     *
     * @return upstream - 上游
     */
    public Integer getUpstream() {
        return upstream;
    }

    /**
     * 设置上游
     *
     * @param upstream 上游
     */
    public void setUpstream(Integer upstream) {
        this.upstream = upstream;
    }

    /**
     * 获取中游
     *
     * @return midstream - 中游
     */
    public Integer getMidstream() {
        return midstream;
    }

    /**
     * 设置中游
     *
     * @param midstream 中游
     */
    public void setMidstream(Integer midstream) {
        this.midstream = midstream;
    }

    /**
     * 获取下游
     *
     * @return downstream - 下游
     */
    public Integer getDownstream() {
        return downstream;
    }

    /**
     * 设置下游
     *
     * @param downstream 下游
     */
    public void setDownstream(Integer downstream) {
        this.downstream = downstream;
    }
}