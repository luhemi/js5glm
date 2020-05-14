package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyBaseInfoMapper;
import com.st.smartsecurity.mapper.CompanyIndustryMapper;
import com.st.smartsecurity.mapper.CompanyMapper;
import com.st.smartsecurity.pojo.dto.CompanyBaseInfoDTO;
import com.st.smartsecurity.pojo.dto.CompanyDTO;
import com.st.smartsecurity.pojo.po.Company;
import com.st.smartsecurity.pojo.po.CompanyBaseInfo;
import com.st.smartsecurity.pojo.po.CompanyIndustry;
import com.st.smartsecurity.pojo.vo.CompanyBaseInfoVO;
import com.st.smartsecurity.pojo.vo.params.CompanyParamsVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 公司基本信息接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyBaseInfoServiceImpl implements CompanyBaseInfoService {

    @Resource
    CompanyBaseInfoMapper companyBaseInfoMapper;
    @Resource
    CompanyIndustryMapper companyIndustryMapper;
    @Resource
    CompanyMapper companyMapper;

    @Override
    public void addBaseInfo(CompanyBaseInfoVO companyBaseInfoVO) {
        CompanyBaseInfo companyBaseInfo = BeanUtil.copyProperties(companyBaseInfoVO, CompanyBaseInfo.class);
        if(companyBaseInfoVO.getEconkindImgs().get(0) != null){
            companyBaseInfo.setEconkindImg(companyBaseInfoVO.getEconkindImgs().get(0));
        }
        if(companyBaseInfoVO.getEconkindImgs().get(1) != null){
            companyBaseInfo.setEconkindImg2(companyBaseInfoVO.getEconkindImgs().get(1));
        }
        addIndustry(companyBaseInfoVO);
        companyBaseInfoMapper.insertSelective(companyBaseInfo);
    }

    @Override
    public void updateBaseInfo(CompanyBaseInfoVO companyBaseInfoVO) {
        CompanyBaseInfo companyBaseInfo = BeanUtil.copyProperties(companyBaseInfoVO, CompanyBaseInfo.class);
        companyBaseInfo.setId(companyBaseInfoVO.getCompanyBaseInfoId());

        CompanyBaseInfo companyImg = new CompanyBaseInfo();
        companyImg.setId(companyBaseInfoVO.getCompanyBaseInfoId());
        companyImg.setEconkindImg("");
        companyImg.setEconkindImg2("");
        companyBaseInfoMapper.updateByPrimaryKeySelective(companyImg);
        if(companyBaseInfoVO.getEconkindImgs().size() > 0){
            
            if(companyBaseInfoVO.getEconkindImgs().get(0) != null){
                companyBaseInfo.setEconkindImg(companyBaseInfoVO.getEconkindImgs().get(0));
            }
            if(companyBaseInfoVO.getEconkindImgs().get(1) != null){
                companyBaseInfo.setEconkindImg2(companyBaseInfoVO.getEconkindImgs().get(1));
            }
        }

        if(companyBaseInfoVO.getIndustryList().size() > 0){
            CompanyIndustry delIndustry = new CompanyIndustry();
            delIndustry.setState(OftenConstant.DELETE_STATE);
            Example example = new Example(CompanyIndustry.class);
            example.createCriteria().andEqualTo("companyId",companyBaseInfoVO.getCompanyId());
            companyIndustryMapper.updateByExampleSelective(delIndustry, example);
            addIndustry(companyBaseInfoVO);
        }
        companyBaseInfoMapper.updateByPrimaryKeySelective(companyBaseInfo);
    }

    @Override
    public CompanyBaseInfoDTO getBaseInfo(Long companyId) {
        Example example = new Example(CompanyBaseInfo.class);
        example.createCriteria().andEqualTo("companyId",companyId);
        List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.selectByExample(example);
        Preconditions.checkArgument(companyBaseInfoList.size() > 0,"没有公司的基本信息");

        CompanyBaseInfo companyBaseInfo = companyBaseInfoList.get(0);
        CompanyBaseInfoDTO companyBaseInfoDTO = BeanUtil.copyProperties(companyBaseInfo, CompanyBaseInfoDTO.class);
        companyBaseInfoDTO.setCompanyBaseInfoId(companyBaseInfo.getId());

        List<String> imgList = Lists.newArrayList();
        if(companyBaseInfo.getEconkindImg() != null){
            imgList.add(companyBaseInfo.getEconkindImg());
        }
        if(companyBaseInfo.getEconkindImg2() != null){
            imgList.add(companyBaseInfo.getEconkindImg2());
        }
        companyBaseInfoDTO.setEconkindImg(imgList);

        Example industryExample = new Example(CompanyIndustry.class);
        industryExample.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("state",OftenConstant.DELETE_STATE);
        List<CompanyIndustry> companyIndustryList = companyIndustryMapper.selectByExample(industryExample);
        List<Integer[]> industryList = Lists.newArrayList();
        for (CompanyIndustry companyIndustry : companyIndustryList) {
            List<Integer> industry = getMiddleStringArray(companyIndustry.getIndustry());
            Integer[] industryArr = industry.toArray(new Integer[industry.size()]);
            industryList.add(industryArr);
        }
        companyBaseInfoDTO.setIndustryList(industryList);
        return companyBaseInfoDTO;
    }

    @Override
    public void addIndustry(CompanyBaseInfoVO companyBaseInfoVO) {
        for (String industry : companyBaseInfoVO.getIndustryList()) {
            List<Integer> streams = getMiddleStringArray(industry);
            CompanyIndustry companyIndustry = new CompanyIndustry();
            companyIndustry.setCompanyId(companyBaseInfoVO.getCompanyId());
            companyIndustry.setIndustry(industry);
            companyIndustry.setState(OftenConstant.NORMAL_STATE);
            companyIndustry.setUpstream(streams.get(0));
            companyIndustry.setMidstream(streams.get(1));
            companyIndustry.setDownstream(streams.get(2));
            companyIndustryMapper.insertSelective(companyIndustry);
        }
    }

    @Override
    public List<Integer> getMiddleStringArray(String str) {
        if(StringUtils.isEmpty(str) || str.length() ==0){
            return new ArrayList<>();
        }
        str = str.substring(0, str.length()-1);
        str = str.substring(1, str.length());
        String[] strings = str.split(",");
        List<Integer> list = Lists.newArrayList();
        for (String string : strings) {
            list.add(Integer.valueOf(string));
        }
        return list;
    }

    @Override
    public PageInfo listCompany(CompanyParamsVO companyParamsVO) {
        PageHelper.startPage(companyParamsVO.getPageNum(), companyParamsVO.getPageSize());

        Example example = new Example(Company.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(!StringUtils.isEmpty(companyParamsVO.getComName())){
            criteria.andLike("comName", "%"+companyParamsVO.getComName()+"%");
        }
        List<Company> companyList = companyMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyList);

        List<Company> waitCompanyList = pageInfo.getList();
        List<CompanyDTO> companyDTOList = Lists.newArrayList();
        for (Company company : waitCompanyList) {
            CompanyDTO companyDTO = BeanUtil.copyProperties(company, CompanyDTO.class);
            companyDTO.setCompanyId(company.getId());
            companyDTO.setPwd(null);
            companyDTOList.add(companyDTO);
        }
        pageInfo.setList(companyDTOList);
        return pageInfo;
    }

    @Override
    public void updateCompanyAdmin(Long companyId, Integer isAdmin) {
        Company company = new Company();
        company.setId(companyId);
        company.setIsAdmin(isAdmin);
        companyMapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public List<Long> listCompanyIdByStream(int streamType) {
        Example example = new Example(CompanyIndustry.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(streamType == 1){
            criteria.andEqualTo("upstream", streamType);
        }
        if(streamType == 2){
            criteria.andEqualTo("upstream", streamType);
        }
        if(streamType == 3){
            criteria.andEqualTo("upstream", streamType);
        }
        List<CompanyIndustry> companyIndustryList = companyIndustryMapper.selectByExample(example);
        List<Long> idList = Lists.newArrayList();
        idList.add(-1L);
        for (CompanyIndustry companyIndustry : companyIndustryList) {
            if(!idList.contains(companyIndustry.getCompanyId())){
                idList.add(companyIndustry.getCompanyId());
            }
        }
        return idList;
    }

    @Override
    public List<Long> listCompanyIdByName(String companyName) {
        Example example = new Example(Company.class);
        example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE).andLike("comName", "%"+companyName+"%");
        List<Company> companyList = companyMapper.selectByExample(example);

        List<Long> companyIdList = Lists.newArrayList();
        companyIdList.add(-1L);
        for (Company company : companyList) {
            companyIdList.add(company.getId());
        }
        return companyIdList;
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = new Company();
        company.setId(companyId);
        company.setState(OftenConstant.DELETE_STATE);
        companyMapper.updateByPrimaryKeySelective(company);
    }
}
