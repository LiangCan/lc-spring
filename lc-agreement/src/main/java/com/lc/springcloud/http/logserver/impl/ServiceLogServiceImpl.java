package com.lc.springcloud.http.logserver.impl;


import com.lc.springcloud.exception.CustomRunTimeException;
import com.lc.springcloud.http.logserver.ServiceLogService;
import com.lc.springcloud.pojo.ServiceLog;
import com.lc.springcloud.repository.ServiceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Liang on 2016/12/23.
 */
@Service
@Transactional( propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT, rollbackFor = CustomRunTimeException.class)
public class ServiceLogServiceImpl implements ServiceLogService {

    @Autowired
    ServiceLogRepository serviceLogRepository;

    @Override
    public void addServiceLog(ServiceLog serviceLog) {
        serviceLogRepository.save(serviceLog);
    }
}
