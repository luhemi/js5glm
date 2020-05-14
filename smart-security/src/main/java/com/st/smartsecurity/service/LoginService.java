package com.st.smartsecurity.service;

import com.st.smartsecurity.pojo.dto.CompanyDTO;
import com.st.smartsecurity.pojo.vo.CompanyVO;
import com.st.smartsecurity.pojo.vo.PasswordVO;

/**
 * 用户登录注册
 * @author lhm
 */
public interface LoginService {

    /**
     * 用户注册
     * @param companyVO
     */
    void register(CompanyVO companyVO);

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    CompanyDTO login(String userName, String userPassword);

    /**
     * 重置密码
     * @param comCode
     * @return
     */
    CompanyDTO reset(String comCode);

    /**
     * 修改密码
     * @param passwordVO
     * @return
     */
    void updatePwd(PasswordVO passwordVO);
}
