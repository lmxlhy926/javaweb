package com.byjs.imperial.court.service.api;

import com.byjs.imperial.court.entity.Emp;

public interface EmpService {
    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
