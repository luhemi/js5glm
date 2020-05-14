package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyOtherDemandMapper;
import com.st.smartsecurity.mapper.CompanyProductDemandMapper;
import com.st.smartsecurity.mapper.CompanyProjectDemandMapper;
import com.st.smartsecurity.pojo.dto.CompanyOtherDemandDTO;
import com.st.smartsecurity.pojo.dto.CompanyProductDemandDTO;
import com.st.smartsecurity.pojo.dto.CompanyProjectDemandDTO;
import com.st.smartsecurity.pojo.po.CompanyOtherDemand;
import com.st.smartsecurity.pojo.po.CompanyProduct;
import com.st.smartsecurity.pojo.po.CompanyProductDemand;
import com.st.smartsecurity.pojo.po.CompanyProjectDemand;
import com.st.smartsecurity.pojo.vo.CompanyOtherDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProductDemandVO;
import com.st.smartsecurity.pojo.vo.CompanyProjectDemandVO;
import com.st.smartsecurity.pojo.vo.params.CompanyDemandParamsVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import com.st.smartsecurity.service.CompanyDemandService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 公司需求接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyDemandServiceImpl implements CompanyDemandService {

    @Resource
    CompanyProductDemandMapper companyProductDemandMapper;
    @Resource
    CompanyProjectDemandMapper companyProjectDemandMapper;
    @Resource
    CompanyOtherDemandMapper companyOtherDemandMapper;
    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @Override
    public void addProductDemand(CompanyProductDemandVO companyProductDemandVO) {
        CompanyProductDemand companyProductDemand = BeanUtil.copyProperties(companyProductDemandVO, CompanyProductDemand.class);
        companyProductDemand.setCreateDate(new Date());
        companyProductDemand.setState(OftenConstant.WAIT_STATE);
        companyProductDemand.setEncryptionCode(RandomStringUtils.randomAlphanumeric(10));
        companyProductDemandMapper.insertSelective(companyProductDemand);
    }

    @Override
    public void deleteProductDemand(Long companyProductDemandId, String comName) {
        CompanyProductDemand companyProductDemand = new CompanyProductDemand();
        companyProductDemand.setCompanyProductDemandId(companyProductDemandId);
        companyProductDemand.setState(OftenConstant.DELETE_STATE);
        companyProductDemandMapper.updateByPrimaryKeySelective(companyProductDemand);
    }

    @Override
    public CompanyProductDemandDTO getCompanyProductDemand(Long companyProductDemandId) {
        CompanyProductDemand companyProductDemand = new CompanyProductDemand();
        companyProductDemand.setCompanyProductDemandId(companyProductDemandId);
        CompanyProductDemand result = companyProductDemandMapper.selectByPrimaryKey(companyProductDemand);
        CompanyProductDemandDTO companyProductDemandDTO = BeanUtil.copyProperties(result, CompanyProductDemandDTO.class);
        companyProductDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(result.getDemandClass()));
        return companyProductDemandDTO;
    }

    @Override
    public PageInfo listCompanyProductDemand(CompanyDemandParamsVO companyDemandParamsVO) {
        Example example = new Example(CompanyProductDemand.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(StringUtils.isNotEmpty(companyDemandParamsVO.getComName())){
            criteria.andIn("companyId",companyBaseInfoService.listCompanyIdByName(companyDemandParamsVO.getComName()));
        }
        example.setOrderByClause("create_date DESC");
        PageHelper.startPage(companyDemandParamsVO.getPageNum(), companyDemandParamsVO.getPageSize());

        List<CompanyProductDemand> companyProductDemandList = companyProductDemandMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyProductDemandList);

        List<CompanyProductDemand> companyProductDemands = pageInfo.getList();
        List<CompanyProductDemandDTO> companyProductDemandDTOList = Lists.newArrayList();
        for (CompanyProductDemand companyProductDemand : companyProductDemands) {
            CompanyProductDemandDTO companyProductDemandDTO = BeanUtil.copyProperties(companyProductDemand, CompanyProductDemandDTO.class);
            companyProductDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(companyProductDemand.getDemandClass()));
            companyProductDemandDTOList.add(companyProductDemandDTO);
        }
        pageInfo.setList(companyProductDemandDTOList);
        return pageInfo;
    }

    @Override
    public void addProjectDemand(CompanyProjectDemandVO companyProjectDemandVO) {
        CompanyProjectDemand companyProjectDemand = BeanUtil.copyProperties(companyProjectDemandVO, CompanyProjectDemand.class);
        companyProjectDemand.setCreateDate(new Date());
        companyProjectDemand.setState(OftenConstant.WAIT_STATE);
        companyProjectDemand.setEncryptionCode(RandomStringUtils.randomAlphanumeric(10));
        companyProjectDemandMapper.insertSelective(companyProjectDemand);
    }

    @Override
    public void deleteProjectDemand(Long companyProjectDemandId, String comName) {
        CompanyProjectDemand companyProjectDemand = new CompanyProjectDemand();
        companyProjectDemand.setCompanyProjectDemandId(companyProjectDemandId);
        companyProjectDemand.setState(OftenConstant.DELETE_STATE);
        companyProjectDemandMapper.updateByPrimaryKeySelective(companyProjectDemand);
    }

    @Override
    public CompanyProjectDemandDTO getCompanyProjectDemand(Long companyProjectDemandId) {
        CompanyProjectDemand companyProjectDemand = new CompanyProjectDemand();
        companyProjectDemand.setCompanyProjectDemandId(companyProjectDemandId);
        CompanyProjectDemand result = companyProjectDemandMapper.selectByPrimaryKey(companyProjectDemand);
        CompanyProjectDemandDTO companyProjectDemandDTO = BeanUtil.copyProperties(result, CompanyProjectDemandDTO.class);
        companyProjectDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(result.getDemandClass()));
        return companyProjectDemandDTO;
    }

    @Override
    public PageInfo listCompanyProjectDemand(CompanyDemandParamsVO companyDemandParamsVO) {
        Example example = new Example(CompanyProjectDemand.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(StringUtils.isNotEmpty(companyDemandParamsVO.getComName())){
            criteria.andIn("companyId",companyBaseInfoService.listCompanyIdByName(companyDemandParamsVO.getComName()));
        }
        example.setOrderByClause("create_date DESC");
        PageHelper.startPage(companyDemandParamsVO.getPageNum(), companyDemandParamsVO.getPageSize());

        List<CompanyProjectDemand> companyProjectDemandList = companyProjectDemandMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyProjectDemandList);

        List<CompanyProjectDemand> companyProjectDemands = pageInfo.getList();
        List<CompanyProjectDemandDTO> companyProjectDemandDTOList = Lists.newArrayList();
        for (CompanyProjectDemand companyProjectDemand : companyProjectDemands) {
            CompanyProjectDemandDTO companyProjectDemandDTO = BeanUtil.copyProperties(companyProjectDemand, CompanyProjectDemandDTO.class);
            companyProjectDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(companyProjectDemand.getDemandClass()));
            companyProjectDemandDTOList.add(companyProjectDemandDTO);
        }
        pageInfo.setList(companyProjectDemandDTOList);
        return pageInfo;
    }

    @Override
    public void addOtherDemand(CompanyOtherDemandVO companyOtherDemandVO) {
        CompanyOtherDemand companyOtherDemand = BeanUtil.copyProperties(companyOtherDemandVO, CompanyOtherDemand.class);
        companyOtherDemand.setCreateDate(new Date());
        companyOtherDemand.setState(OftenConstant.WAIT_STATE);
        companyOtherDemand.setEncryptionCode(RandomStringUtils.randomAlphanumeric(10));
        companyOtherDemandMapper.insertSelective(companyOtherDemand);
    }

    @Override
    public void deleteOtherDemand(Long companyOtherDemandId, String comName) {
        CompanyOtherDemand companyOtherDemand = new CompanyOtherDemand();
        companyOtherDemand.setCompanyOtherDemandId(companyOtherDemandId);
        companyOtherDemand.setState(OftenConstant.DELETE_STATE);
        companyOtherDemandMapper.updateByPrimaryKeySelective(companyOtherDemand);
    }

    @Override
    public CompanyOtherDemandDTO getCompanyOtherDemand(Long companyOtherDemandId) {
        CompanyOtherDemand companyOtherDemand = new CompanyOtherDemand();
        companyOtherDemand.setCompanyOtherDemandId(companyOtherDemandId);
        CompanyOtherDemand result = companyOtherDemandMapper.selectByPrimaryKey(companyOtherDemand);
        CompanyOtherDemandDTO companyOtherDemandDTO = BeanUtil.copyProperties(result, CompanyOtherDemandDTO.class);
        companyOtherDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(result.getDemandClass()));
        return companyOtherDemandDTO;
    }

    @Override
    public PageInfo listCompanyOtherDemand(CompanyDemandParamsVO companyDemandParamsVO) {
        Example example = new Example(CompanyOtherDemand.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(StringUtils.isNotEmpty(companyDemandParamsVO.getComName())){
            criteria.andIn("companyId",companyBaseInfoService.listCompanyIdByName(companyDemandParamsVO.getComName()));
        }
        example.setOrderByClause("create_date DESC");
        PageHelper.startPage(companyDemandParamsVO.getPageNum(), companyDemandParamsVO.getPageSize());

        List<CompanyOtherDemand> companyOtherDemandList = companyOtherDemandMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyOtherDemandList);

        List<CompanyOtherDemand> companyOtherDemands = pageInfo.getList();
        List<CompanyOtherDemandDTO> companyOtherDemandDTOList = Lists.newArrayList();
        for (CompanyOtherDemand companyOtherDemand : companyOtherDemands) {
            CompanyOtherDemandDTO companyOtherDemandDTO = BeanUtil.copyProperties(companyOtherDemand, CompanyOtherDemandDTO.class);
            companyOtherDemandDTO.setDemandClass(companyBaseInfoService.getMiddleStringArray(companyOtherDemand.getDemandClass()));
            companyOtherDemandDTOList.add(companyOtherDemandDTO);
        }
        pageInfo.setList(companyOtherDemandDTOList);
        return pageInfo;
    }
}
