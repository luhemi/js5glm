package com.st.smartsecurity.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyProjectImgMapper;
import com.st.smartsecurity.mapper.CompanyProjectMapper;
import com.st.smartsecurity.pojo.dto.CompanyProductDTO;
import com.st.smartsecurity.pojo.dto.CompanyProjectDTO;
import com.st.smartsecurity.pojo.dto.CompanyProjectImgDTO;
import com.st.smartsecurity.pojo.po.CompanyProduct;
import com.st.smartsecurity.pojo.po.CompanyProductImg;
import com.st.smartsecurity.pojo.po.CompanyProject;
import com.st.smartsecurity.pojo.po.CompanyProjectImg;
import com.st.smartsecurity.pojo.vo.CompanyProjectVO;
import com.st.smartsecurity.pojo.vo.params.CompanyProjectParamsVO;
import com.st.smartsecurity.service.CompanyBaseInfoService;
import com.st.smartsecurity.service.CompanyProjectService;
import com.st.smartsecurity.util.AddLogUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 公司项目接口
 * @author lhm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyProjectServiceImpl implements CompanyProjectService {
    @Resource
    CompanyProjectMapper companyProjectMapper;
    @Resource
    CompanyProjectImgMapper companyProjectImgMapper;
    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @Override
    public void addProject(CompanyProjectVO companyProjectVO) {
        CompanyProject companyProject = BeanUtil.copyProperties(companyProjectVO, CompanyProject.class);
        companyProject.setState(OftenConstant.WAIT_STATE);
        companyProject.setCreateDate(new Date());
        companyProject.setEncryptionCode(RandomStringUtils.randomAlphanumeric(10));
        companyProjectMapper.insertSelective(companyProject);
        //产品图片
        /*if(companyProjectVO.getImgList() != null && companyProjectVO.getImgList().size() != 0){
            CompanyProjectImg projectImg = new CompanyProjectImg();
            projectImg.setState(OftenConstant.DELETE_STATE);
            Example example = new Example(CompanyProjectImg.class);
            example.createCriteria().andEqualTo("projectId",companyProject.getId());
            companyProjectImgMapper.updateByExampleSelective(projectImg,example);

            for (String imgAddress:companyProjectVO.getImgList()) {
                CompanyProjectImg companyProjectImg = new CompanyProjectImg();
                companyProjectImg.setCreateDate(new Date());
                companyProjectImg.setImgUrl(imgAddress);
                companyProjectImg.setProjectId(companyProject.getId());
                companyProjectImg.setState(OftenConstant.NORMAL_STATE);
                companyProjectImgMapper.insertSelective(companyProjectImg);
            }
        }*/
    }

    @Override
    public void deleteProject(Long companyProjectId, String comName) {
        CompanyProject companyProject = new CompanyProject();
        companyProject.setId(companyProjectId);
        companyProject.setState(OftenConstant.DELETE_STATE);
        companyProjectMapper.updateByPrimaryKeySelective(companyProject);
    }

    @Override
    public void updateProject(CompanyProjectVO companyProjectVO) {
        CompanyProject companyProject = BeanUtil.copyProperties(companyProjectVO, CompanyProject.class);
        companyProject.setState(OftenConstant.WAIT_STATE);
        companyProjectMapper.updateByPrimaryKeySelective(companyProject);

        /*CompanyProjectImg projectImg = new CompanyProjectImg();
        projectImg.setState(OftenConstant.DELETE_STATE);
        Example example = new Example(CompanyProjectImg.class);
        example.createCriteria().andEqualTo("projectId",companyProject.getId());
        companyProjectImgMapper.updateByExampleSelective(projectImg,example);
        //产品图片
        if(companyProjectVO.getImgList() != null && companyProjectVO.getImgList().size() != 0){
            for (String imgAddress:companyProjectVO.getImgList()) {
                CompanyProjectImg companyProjectImg = new CompanyProjectImg();
                companyProjectImg.setCreateDate(new Date());
                companyProjectImg.setImgUrl(imgAddress);
                companyProjectImg.setProjectId(companyProject.getId());
                companyProjectImg.setState(OftenConstant.NORMAL_STATE);
                companyProjectImgMapper.insertSelective(companyProjectImg);
            }
        }*/
    }

    @Override
    public CompanyProjectDTO getCompanyProject(Long companyProjectId) {
        CompanyProject companyProject = new CompanyProject();
        companyProject.setId(companyProjectId);
        CompanyProject result = companyProjectMapper.selectByPrimaryKey(companyProjectId);
        CompanyProjectDTO companyProjectDTO = BeanUtil.copyProperties(result, CompanyProjectDTO.class);
        companyProjectDTO.setCompanyProjectId(result.getId());
        companyProjectDTO.setIndustry(companyBaseInfoService.getMiddleStringArray(result.getIndustry()));

        CompanyProjectImg companyProjectImg = new CompanyProjectImg();
        companyProjectImg.setState(OftenConstant.NORMAL_STATE);
        companyProjectImg.setProjectId(result.getId());
        List<CompanyProjectImg> companyProjectImgList = companyProjectImgMapper.select(companyProjectImg);

        List<CompanyProjectImgDTO> imgList = Lists.newArrayList();
        for (CompanyProjectImg projectImg : companyProjectImgList) {
            CompanyProjectImgDTO companyProjectImgDTO = BeanUtil.copyProperties(projectImg, CompanyProjectImgDTO.class);
            companyProjectImgDTO.setCompanyProjectImgId(projectImg.getId());
            imgList.add(companyProjectImgDTO);
        }
        companyProjectDTO.setImgList(imgList);
        return companyProjectDTO;
    }

    @Override
    public PageInfo listCompanyProject(CompanyProjectParamsVO companyProjectParamsVO) {
        Example example = new Example(CompanyProject.class);
        Example.Criteria criteria = example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);
        if(companyProjectParamsVO.getCompanyId() != null){
            criteria .andEqualTo("companyId",companyProjectParamsVO.getCompanyId());
        }
        example.setOrderByClause("project_end DESC");
        PageHelper.startPage(companyProjectParamsVO.getPageNum(), companyProjectParamsVO.getPageSize());

        List<CompanyProject> companyProjectList = companyProjectMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(companyProjectList);

        List<CompanyProject> companyProjects = pageInfo.getList();
        List<CompanyProjectDTO> companyProjectDTOList = Lists.newArrayList();
        for (CompanyProject companyProject : companyProjects) {
            CompanyProjectDTO companyProjectDTO = BeanUtil.copyProperties(companyProject, CompanyProjectDTO.class);
            companyProjectDTO.setCompanyProjectId(companyProject.getId());
            companyProjectDTO.setIndustry(companyBaseInfoService.getMiddleStringArray(companyProject.getIndustry()));
            companyProjectDTOList.add(companyProjectDTO);
        }
        pageInfo.setList(companyProjectDTOList);
        return pageInfo;
    }

    @Override
    public List<CompanyProjectDTO> listProject() {
        Example example = new Example(CompanyProject.class);
        example.createCriteria().andNotEqualTo("state", OftenConstant.DELETE_STATE);

        List<CompanyProject> companyProjectList = companyProjectMapper.selectByExample(example);

        List<CompanyProjectDTO> companyProjectDTOList = Lists.newArrayList();
        for (CompanyProject companyProject : companyProjectList) {
            CompanyProjectDTO companyProjectDTO = BeanUtil.copyProperties(companyProject, CompanyProjectDTO.class);
            companyProjectDTO.setCompanyProjectId(companyProject.getId());
            companyProjectDTOList.add(companyProjectDTO);
        }

        return companyProjectDTOList;
    }

    @Override
    public void checkCompanyProject(Long companyProjectId, String state, String rejected) {
        CompanyProject companyProject = new CompanyProject();
        companyProject.setId(companyProjectId);
        companyProject.setState(state);
        if(!StringUtils.isEmpty(rejected)){
            companyProject.setRejected(rejected);
        }
        companyProjectMapper.updateByPrimaryKeySelective(companyProject);
    }
}
