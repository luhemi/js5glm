package com.st.smartsecurity.service.Impl;

import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.*;
import com.st.smartsecurity.pojo.dto.*;
import com.st.smartsecurity.pojo.po.*;
import com.st.smartsecurity.pojo.vo.ScreenProductVO;
import com.st.smartsecurity.pojo.vo.ScreenStreamVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import com.st.smartsecurity.service.ScreenService;
import com.st.smartsecurity.util.CompanyCityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 大屏接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScreenServiceImpl implements ScreenService {

    @Resource
    CompanyBaseInfoMapper companyBaseInfoMapper;
    @Resource
    CompanyProductMapper companyProductMapper;
    @Resource
    CompanyProjectMapper companyProjectMapper;
    @Resource
    CompanyProductDemandMapper companyProductDemandMapper;
    @Resource
    CompanyProjectDemandMapper companyProjectDemandMapper;
    @Resource
    CompanyOtherDemandMapper companyOtherDemandMapper;
//    @Resource
//    CompanyDemandMapper companyDemandMapper;
    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @Override
    public List<ScreenBaseDTO> listBaseInfoByStream(ScreenStreamVO screenStreamVO) {
        Example example = new Example(CompanyBaseInfo.class);
        Example.Criteria criteria = example.createCriteria();

        List<Long> companyIdList = companyBaseInfoService.listCompanyIdByStream(screenStreamVO.getType());
        criteria.andIn("companyId", companyIdList);
        List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.selectByExample(example);

        List<String> cityIdList = Lists.newArrayList();
        for (CompanyBaseInfo companyBaseInfo : companyBaseInfoList) {
            if(!cityIdList.contains(companyBaseInfo.getCity())){
                cityIdList.add(companyBaseInfo.getCity());
            }
        }

        List<ScreenBaseDTO> screenBaseDTOList = Lists.newArrayList();

        for (String s : cityIdList) {
            ScreenBaseDTO screenBaseDTO = new ScreenBaseDTO();
            screenBaseDTO.setType("Feature");
            ScreenStreamBaseInfoDTO screenStreamBaseInfoDTO = new ScreenStreamBaseInfoDTO();
            Example cityExample = new Example(CompanyBaseInfo.class);
            Example.Criteria cityCriteria = cityExample.createCriteria();

            cityCriteria.andIn("companyId", companyIdList);
            cityCriteria.andEqualTo("city", s);
            List<CompanyBaseInfo> companyBaseInfos = companyBaseInfoMapper.selectByExample(cityExample);

            List<CompanyBaseInfoDTO> companyBaseInfoDTOList = Lists.newArrayList();
            for (CompanyBaseInfo companyBaseInfo : companyBaseInfos) {
                CompanyBaseInfoDTO companyBaseInfoDTO = BeanUtil.copyProperties(companyBaseInfo, CompanyBaseInfoDTO.class);
                companyBaseInfoDTO.setCompanyBaseInfoId(companyBaseInfo.getId());
                companyBaseInfoDTOList.add(companyBaseInfoDTO);
            }

            screenStreamBaseInfoDTO.setId(Integer.valueOf(s));
            screenStreamBaseInfoDTO.setCity(CompanyCityUtil.getCity(s));
            screenStreamBaseInfoDTO.setMag(companyBaseInfos.size());
            screenStreamBaseInfoDTO.setTime(1507425650893L);
            screenStreamBaseInfoDTO.setFelt(null);
            screenStreamBaseInfoDTO.setTsunami(0);
            screenStreamBaseInfoDTO.setComList(companyBaseInfoDTOList);

            screenBaseDTO.setProperties(screenStreamBaseInfoDTO);

            ScreenCityCoordinatesDTO screenCityCoordinatesDTO = new ScreenCityCoordinatesDTO();
            screenCityCoordinatesDTO.setType("Point");
            screenCityCoordinatesDTO.setCoordinates(CompanyCityUtil.getCoordinates(s));

            screenBaseDTO.setGeometry(screenCityCoordinatesDTO);

            screenBaseDTOList.add(screenBaseDTO);
        }
        return screenBaseDTOList;
    }

    @Override
    public ScreenProductDTO listProductByStream(ScreenProductVO screenProductVO) {
        Example example = new Example(CompanyBaseInfo.class);
        Example.Criteria criteria = example.createCriteria();

        List<Long> comIdList = companyBaseInfoService.listCompanyIdByStream(screenProductVO.getType());
        criteria.andIn("companyId", comIdList);
        if(!StringUtils.isEmpty(screenProductVO.getCompanyName())){
            criteria.andLike("comName", "%"+screenProductVO.getCompanyName()+"%");
        }
        List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoMapper.selectByExample(example);

        List<Long> companyIdList = Lists.newArrayList();
        for (CompanyBaseInfo companyBaseInfo : companyBaseInfoList) {
            if(!companyIdList.contains(companyBaseInfo.getCompanyId())){
                companyIdList.add(companyBaseInfo.getCompanyId());
            }
        }

        ScreenProductDTO screenProductDTO = new ScreenProductDTO();
        List<CompanyProductDTO> companyProductDTOList = Lists.newArrayList();
        List<CompanyProjectDTO> companyProjectDTOList = Lists.newArrayList();
        List<CompanyProductDemandDTO> companyProductDemandDTOList = Lists.newArrayList();
        List<CompanyProjectDemandDTO> companyProjectDemandDTOList = Lists.newArrayList();
        List<CompanyOtherDemandDTO> companyOtherDemandDTOList = Lists.newArrayList();
        for (Long id : companyIdList) {
            //产品
            if(screenProductVO.getProductType() == 1){
                Example productExample = new Example(CompanyProduct.class);
                Example.Criteria productCriteria = productExample.createCriteria();
                productCriteria.andNotEqualTo("state", OftenConstant.DELETE_STATE).andEqualTo("companyId", id);
                if(!StringUtils.isEmpty(screenProductVO.getProductName())){
                    productCriteria.andLike("productName","%"+screenProductVO.getProductName()+"%");
                }
                List<CompanyProduct> companyProductList = companyProductMapper.selectByExample(productExample);

                for (CompanyProduct companyProduct : companyProductList) {
                    CompanyProductDTO companyProductDTO = BeanUtil.copyProperties(companyProduct, CompanyProductDTO.class);
                    companyProductDTO.setCompanyProductId(companyProduct.getId());
                    companyProductDTOList.add(companyProductDTO);
                }
            }
            //项目
            if(screenProductVO.getProductType() == 2){
                Example projectExample = new Example(CompanyProject.class);
                Example.Criteria projectCriteria = projectExample.createCriteria();
                projectCriteria.andNotEqualTo("state", OftenConstant.DELETE_STATE).andEqualTo("companyId", id);
                if(!StringUtils.isEmpty(screenProductVO.getProductName())){
                    projectCriteria.andLike("projectName","%"+screenProductVO.getProductName()+"%");
                }
                List<CompanyProject> companyProjectList = companyProjectMapper.selectByExample(projectExample);

                for (CompanyProject companyProject : companyProjectList) {
                    CompanyProjectDTO companyProjectDTO = BeanUtil.copyProperties(companyProject, CompanyProjectDTO.class);
                    companyProjectDTO.setCompanyProjectId(companyProject.getId());
                    companyProjectDTOList.add(companyProjectDTO);
                }
            }
            //需求
            if(screenProductVO.getProductType() == 3){
                //公司产品需求
                Example productDemandExample = new Example(CompanyProductDemand.class);
                Example.Criteria productDemandCriteria = productDemandExample.createCriteria();
                productDemandCriteria.andNotEqualTo("state", OftenConstant.DELETE_STATE).andEqualTo("companyId", id);

                List<CompanyProductDemand> companyProductDemandList = companyProductDemandMapper.selectByExample(productDemandExample);

                for (CompanyProductDemand companyProductDemand : companyProductDemandList) {
                    CompanyProductDemandDTO companyProductDemandDTO = BeanUtil.copyProperties(companyProductDemand, CompanyProductDemandDTO.class);
                    CompanyProduct companyProduct = companyProductMapper.selectByPrimaryKey(companyProductDemandDTO.getCompanyProductId());
                    companyProductDemandDTO.setCompanyProductName(companyProduct.getProductName());
                    companyProductDemandDTOList.add(companyProductDemandDTO);
                }

                //公司项目需求
                Example projectDemandExample = new Example(CompanyProjectDemand.class);
                Example.Criteria projectDemandExampleCriteria = projectDemandExample.createCriteria();
                projectDemandExampleCriteria.andNotEqualTo("state", OftenConstant.DELETE_STATE).andEqualTo("companyId", id);

                List<CompanyProjectDemand> companyProjectDemandList = companyProjectDemandMapper.selectByExample(projectDemandExample);

                for (CompanyProjectDemand companyProjectDemand : companyProjectDemandList) {
                    CompanyProjectDemandDTO companyProjectDemandDTO = BeanUtil.copyProperties(companyProjectDemand, CompanyProjectDemandDTO.class);
                    CompanyProject companyProject = companyProjectMapper.selectByPrimaryKey(companyProjectDemandDTO.getCompanyProjectId());
                    companyProjectDemandDTO.setCompanyProjectName(companyProject.getProjectName());
                    companyProjectDemandDTOList.add(companyProjectDemandDTO);
                }

                //公司其它需求
                Example otherDemandExample = new Example(CompanyOtherDemand.class);
                Example.Criteria otherDemandCriteria = otherDemandExample.createCriteria();
                otherDemandCriteria.andNotEqualTo("state", OftenConstant.DELETE_STATE).andEqualTo("companyId", id);

                List<CompanyOtherDemand> companyOtherDemandList = companyOtherDemandMapper.selectByExample(otherDemandExample);

                for (CompanyOtherDemand companyOtherDemand : companyOtherDemandList) {
                    CompanyOtherDemandDTO companyOtherDemandDTO = BeanUtil.copyProperties(companyOtherDemand, CompanyOtherDemandDTO.class);
                    companyOtherDemandDTOList.add(companyOtherDemandDTO);
                }
            }
        }

        screenProductDTO.setCompanyProductDemandDTOList(companyProductDemandDTOList);
        screenProductDTO.setCompanyProjectDemandDTOList(companyProjectDemandDTOList);
        screenProductDTO.setCompanyOtherDemandDTOList(companyOtherDemandDTOList);
        screenProductDTO.setCompanyProjectDTOList(companyProjectDTOList);
        screenProductDTO.setCompanyProductDTOList(companyProductDTOList);
        return screenProductDTO;
    }

    @Override
    public CompanyScaleDTO getScale() {
        CompanyScaleDTO companyScaleDTO = new CompanyScaleDTO();
        Example example = new Example(CompanyBaseInfo.class);

        example.createCriteria().andIn("companyId", companyBaseInfoService.listCompanyIdByStream(1));
        List<CompanyBaseInfo> companyUpBaseInfoList = companyBaseInfoMapper.selectByExample(example);
        companyScaleDTO.setUpstreamCount(companyUpBaseInfoList.size());
        for (CompanyBaseInfo baseInfo : companyUpBaseInfoList) {
            if(baseInfo.getLastincome() != null){
                companyScaleDTO.setUpstreamValueSum(companyScaleDTO.getUpstreamValueSum() + baseInfo.getLastincome());
            }
        }

        example.clear();
        example.createCriteria().andIn("companyId", companyBaseInfoService.listCompanyIdByStream(2));
        List<CompanyBaseInfo> companyMidBaseInfoList = companyBaseInfoMapper.selectByExample(example);
        companyScaleDTO.setMidstreamCount(companyMidBaseInfoList.size());
        for (CompanyBaseInfo baseInfo : companyMidBaseInfoList) {
            if(baseInfo.getLastincome() != null){
                companyScaleDTO.setMidstreamValueSum(companyScaleDTO.getMidstreamValueSum() + baseInfo.getLastincome());
            }
        }

        example.clear();
        example.createCriteria().andIn("companyId", companyBaseInfoService.listCompanyIdByStream(3));
        List<CompanyBaseInfo> companyDownBaseInfoList = companyBaseInfoMapper.selectByExample(example);
        companyScaleDTO.setDownstreamCount(companyDownBaseInfoList.size());
        for (CompanyBaseInfo baseInfo : companyDownBaseInfoList) {
            if(baseInfo.getLastincome() != null){
                companyScaleDTO.setDownstreamValueSum(companyScaleDTO.getDownstreamValueSum() + baseInfo.getLastincome());
            }
        }

       return companyScaleDTO;
    }
}
