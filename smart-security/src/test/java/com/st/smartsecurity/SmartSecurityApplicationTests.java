package com.st.smartsecurity;

import com.st.smartsecurity.service.CompanyBaseInfoService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartSecurityApplicationTests {

    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @Test
    public void contextLoads() {
        String s = RandomStringUtils.randomAlphanumeric(10);
        System.out.println(s);
    }

}
