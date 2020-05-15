package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyProductImgMapper;
import com.st.smartsecurity.mapper.CompanyProductMapper;
import com.st.smartsecurity.pojo.dto.CompanyProductDTO;
import com.st.smartsecurity.pojo.dto.CompanyProductImgDTO;
import com.st.smartsecurity.pojo.po.CompanyProduct;
import com.st.smartsecurity.pojo.po.CompanyProductImg;
import com.st.smartsecurity.pojo.vo.CompanyProductVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProductParamsVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import com.st.smartsecurity.service.CompanyProductService;
import com.st.smartsecurity.util.AddLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyProductServiceImpl implements CompanyProductService {

    @Resource
    CompanyProductMapper companyProductMapper;
    @Autowired
    AddLogUtil addLogUtil;
    @Resource
    CompanyProductImgMapper companyProductImgMapper;
    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @Override
    public void addProduct(CompanyProductVO companyProductVO) {
        CompanyProduct companyProduct = BeanUtil.copyProperties(companyProductVO, CompanyProduct.class);
        companyProduct.setState(OftenConstant.WAIT_STATE);
        companyProduct.setCreateData(new Date());
        companyProductMapper.insertSelective(companyProduct);
        addLogUtil.addLog(companyProductVO.getComName(), "增加了产品");
        //产品图片
        if(companyProductVO.getImgList() != null && companyProductVO.getImgList().size() != 0){
            CompanyProductImg productImg = new CompanyProductImg();
            productImg.setState(OftenConstant.DELETE_STATE);
            Example example = new Example(CompanyProductImg.class);
            example.createCriteria().andEqualTo("productId",companyProduct.getId());
            companyProductImgMapper.updateByExampleSelective(productImg,example);

            for (String imgAddress:companyProductVO.getImgList()) {
                CompanyProductImg companyProductImg = new CompanyProductImg();
                companyProductImg.setCreateDate(new Date());
                companyProductImg.setImgUrl(imgAddress);
                companyProductImg.setProductId(companyProduct.getId());
                companyProductImg.setState(OftenConstant.NORMAL_STATE);
                companyProductImgMapper.insertSelective(companyProductImg);
            }
        }
    }

    @Override
    public void deleteProduct(Long companyProductId, String comName) {
        CompanyProduct companyProduct = new CompanyProduct();
        companyProduct.setId(companyProductId);
        companyProduct.setState(OftenConstant.DELETE_STATE);
        companyProductMapper.updateByPrimaryKeySelective(companyProduct);
        addLogUtil.addLog(comName, "删除了产品");
    }

    @Override
    public void updateProduct(CompanyProductVO companyProductVO) {
        CompanyProduct companyProduct = BeanUtil.copyProperties(companyProductVO, CompanyProduct.class);
        companyProduct.setId(companyProductVO.getCompanyProductId());
        companyProduct.setState(OftenConstant.WAIT_STATE);
        companyProductMapper.updateByPrimaryKeySelective(companyProduct);
        addLogUtil.addLog(companyProductVO.getComName(), "修改了产品");

        CompanyProductImg productImg = new CompanyProductImg();
        productImg.setState(OftenConstant.DELETE_STATE);
        Example example = new Example(CompanyProductImg.class);
        example.createCriteria().andEqualTo("productId",companyProduct.getId());
        companyProductImgMapper.updateByExampleSelective(productImg,example);
        //产品图片
        if(companyProductVO.getImgList() != null && companyProductVO.getImgList().size() != 0){
            for (String imgAddress:companyProductVO.getImgList()) {
                CompanyProductImg companyProductImg = new CompanyProductImg();
                companyProductImg.setCreateDate(new Date());
                companyProductImg.setImgUrl(imgAddress);
                companyProductImg.setProductId(companyProduct.getId());
                companyProductImg.setState(OftenConstant.NORMAL_STATE);
                companyProductImgMapper.insertSelective(companyProductImg);
            }
        }
    }

    @Override
    public CompanyProductDTO getProduct(Long companyProductId) {
        CompanyProduct companyProduct = new CompanyProduct();
        companyProduct.setId(companyProductId);
        CompanyProduct result = companyProductMapper.selectByPrimaryKey(companyProduct);
        CompanyProductDTO companyProductDTO = BeanUtil.copyProperties(result, CompanyProductDTO.class);
        companyProductDTO.setCompanyProductId(result.getId());
//        companyProductDTO.setIndustry(companyBaseInfoService.getMiddleStringArray(result.getIndustry()));

        CompanyProductImg companyProductImg = new CompanyProductImg();
        companyProductImg.setState(OftenConstant.NORMAL_STATE);
        companyProductImg.setProductId(result.getId());
        List<CompanyProductImg> companyProductImgList = companyProductImgMapper.select(companyProductImg);

        List<CompanyProductImgDTO> imgList = Lists.newArrayList();
        for (CompanyProductImg productImg : companyProductImgList) {
            CompanyProductImgDTO companyProductImgDTO = BeanUtil.copyProperties(productImg, CompanyProductImgDTO.class);
            companyProductImgDTO.setCompanyProductImgId(productImg.getId());
            imgList.add(companyProductImgDTO);
        }
        companyProductDTO.setImgList(imgList);
        return companyProductDTO;
    }

    @Override
    public PageInfo listProduct(CompanyProductParamsVO companyProductParamsVO) {
        Example example = new Example(CompanyProduct.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(companyProductParamsVO.getCompanyId() != null){
            criteria.andEqualTo("companyId",companyProductParamsVO.getCompanyId());
        }
        example.setOrderByClause("create_data DESC");
        PageHelper.startPage(companyProductParamsVO.getPageNum(), companyProductParamsVO.getPageSize());

        List<CompanyProduct> companyProductList = companyProductMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyProductList);

        List<CompanyProduct> companyProducts = pageInfo.getList();
        List<CompanyProductDTO> companyProductDTOList = Lists.newArrayList();
        for (CompanyProduct companyProduct : companyProducts) {
            CompanyProductDTO companyProductDTO = BeanUtil.copyProperties(companyProduct, CompanyProductDTO.class);
            companyProductDTO.setCompanyProductId(companyProduct.getId());
//            companyProductDTO.setIndustry(companyBaseInfoService.getMiddleStringArray(companyProduct.getIndustry()));
            companyProductDTOList.add(companyProductDTO);
        }
        pageInfo.setList(companyProductDTOList);
        return pageInfo;
    }

    @Override
    public List<CompanyProductDTO> listProductNotPage() {
        Example example = new Example(CompanyProduct.class);
        example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);

        List<CompanyProduct> companyProductList = companyProductMapper.selectByExample(example);

        List<CompanyProductDTO> companyProductDTOList = Lists.newArrayList();
        for (CompanyProduct companyProduct : companyProductList) {
            CompanyProductDTO companyProductDTO = BeanUtil.copyProperties(companyProduct, CompanyProductDTO.class);
            companyProductDTO.setCompanyProductId(companyProduct.getId());
            companyProductDTOList.add(companyProductDTO);
        }

        return companyProductDTOList;
    }

    @Override
    public void checkCompanyProduct(Long companyProductId, String state, String rejected) {
        CompanyProduct companyProduct = new CompanyProduct();
        companyProduct.setId(companyProductId);
        companyProduct.setState(state);
        if(!StringUtils.isEmpty(rejected)){
            companyProduct.setRejected(rejected);
        }
        companyProductMapper.updateByPrimaryKeySelective(companyProduct);
    }
}
