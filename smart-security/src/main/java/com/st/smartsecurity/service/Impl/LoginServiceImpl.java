package com.st.smartsecurity.service.Impl;

import com.google.common.base.Preconditions;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.OftenConstant;
import com.st.smartsecurity.mapper.CompanyMapper;
import com.st.smartsecurity.pojo.dto.CompanyDTO;
import com.st.smartsecurity.pojo.po.Company;
import com.st.smartsecurity.pojo.vo.CompanyVO;
import com.st.smartsecurity.pojo.vo.PasswordVO;
import com.st.smartsecurity.service.LoginService;
import com.st.smartsecurity.util.AddLogUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Autowired
    AddLogUtil addLogUtil;
    @Resource
    CompanyMapper companyMapper;

    @Override
    public void register(CompanyVO companyVO) {
        Company company = new Company();
        company.setLoginName(companyVO.getLoginName());
        Preconditions.checkArgument(companyMapper.selectCount(company) == 0,"用户名已存在");
        Company companyUser = BeanUtil.copyProperties(companyVO, Company.class);
        companyUser.setPwd(DigestUtils.md5Hex(companyVO.getPwd()));
        companyUser.setCreateDate(new Date());
        companyUser.setState(OftenConstant.WAIT_STATE);
        companyMapper.insertSelective(companyUser);
    }

    @Override
    public CompanyDTO login(String userName, String userPassword) {
        Company user = new Company();
        user.setLoginName(userName);
        user.setPwd(DigestUtils.md5Hex(userPassword));
        List<Company> companyUserList = companyMapper.select(user);
        Preconditions.checkArgument(companyUserList.size() > 0,"用户名或密码错误");
        Company company = companyUserList.get(0);
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyId(company.getId());
        companyDTO.setLoginName(company.getLoginName());
        companyDTO.setComName(company.getComName());
        companyDTO.setIsAdmin(company.getIsAdmin());
        addLogUtil.addLog(company.getComName(), "登录后台");
        return companyDTO;
    }

    @Override
    public CompanyDTO reset(String comCode) {
        Company user = new Company();
        user.setComCode(comCode);
        List<Company> companyUserList = companyMapper.select(user);
        Preconditions.checkArgument(companyUserList.size() != 0,"信用代码不存在");
        Company company = companyUserList.get(0);
        company.setPwd(DigestUtils.md5Hex("qwer1234"));
        companyMapper.updateByPrimaryKeySelective(company);
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setLoginName(company.getLoginName());
        companyDTO.setPwd("qwer1234");
        companyDTO.setCompanyId(company.getId());
        return companyDTO;
    }

    @Override
    public void updatePwd(PasswordVO passwordVO) {
        Example example = new Example(Company.class);
        example.createCriteria().andEqualTo("loginName", passwordVO.getLoginName()).andEqualTo("comCode", passwordVO.getComCode())
                .andNotEqualTo("state", OftenConstant.DELETE_STATE);

        Company company = companyMapper.selectOneByExample(example);

        Preconditions.checkArgument(company != null,"登录名与信用代码不匹配");
        Preconditions.checkArgument(DigestUtils.md5Hex(passwordVO.getPwd()).equals(company.getPwd()),"密码错误");

        company.setPwd(DigestUtils.md5Hex(passwordVO.getNewPwd()));
        companyMapper.updateByPrimaryKeySelective(company);
    }
}
