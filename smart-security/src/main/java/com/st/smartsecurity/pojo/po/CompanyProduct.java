package com.st.smartsecurity.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company_product`")
public class CompanyProduct {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`industry`")
    private String industry;

    /**
     * 产品名称
     */
    @Column(name = "`product_name`")
    private String productName;

    /**
     * 产品介绍
     */
    @Column(name = "`product_introduce`")
    private String productIntroduce;

    /**
     * 产品参数
     */
    @Column(name = "`Product_parameters`")
    private String productParameters;

    /**
     * 产品销售额
     */
    @Column(name = "`product_sales`")
    private String productSales;

    /**
     * 产品关键字
     */
    @Column(name = "`product_keyword`")
    private String productKeyword;

    /**
     * 产品视频
     */
    @Column(name = "`product_video`")
    private String productVideo;

    @Column(name = "`state`")
    private String state;

    @Column(name = "`create_data`")
    private Date createData;

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
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品介绍
     *
     * @return product_introduce - 产品介绍
     */
    public String getProductIntroduce() {
        return productIntroduce;
    }

    /**
     * 设置产品介绍
     *
     * @param productIntroduce 产品介绍
     */
    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce;
    }

    /**
     * 获取产品参数
     *
     * @return Product_parameters - 产品参数
     */
    public String getProductParameters() {
        return productParameters;
    }

    /**
     * 设置产品参数
     *
     * @param productParameters 产品参数
     */
    public void setProductParameters(String productParameters) {
        this.productParameters = productParameters;
    }

    /**
     * 获取产品销售额
     *
     * @return product_sales - 产品销售额
     */
    public String getProductSales() {
        return productSales;
    }

    /**
     * 设置产品销售额
     *
     * @param productSales 产品销售额
     */
    public void setProductSales(String productSales) {
        this.productSales = productSales;
    }

    /**
     * 获取产品关键字
     *
     * @return product_keyword - 产品关键字
     */
    public String getProductKeyword() {
        return productKeyword;
    }

    /**
     * 设置产品关键字
     *
     * @param productKeyword 产品关键字
     */
    public void setProductKeyword(String productKeyword) {
        this.productKeyword = productKeyword;
    }

    /**
     * 获取产品视频
     *
     * @return product_video - 产品视频
     */
    public String getProductVideo() {
        return productVideo;
    }

    /**
     * 设置产品视频
     *
     * @param productVideo 产品视频
     */
    public void setProductVideo(String productVideo) {
        this.productVideo = productVideo;
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
     * @return create_data
     */
    public Date getCreateData() {
        return createData;
    }

    /**
     * @param createData
     */
    public void setCreateData(Date createData) {
        this.createData = createData;
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