package com.st.smartsecurity.service;

import com.github.pagehelper.PageInfo;
import com.st.smartsecurity.pojo.dto.LogDTO;
import com.st.smartsecurity.pojo.vo.params.LogParamsVO;

public interface LogService {

    PageInfo<LogDTO> listLog(LogParamsVO logParamsVO);
}
