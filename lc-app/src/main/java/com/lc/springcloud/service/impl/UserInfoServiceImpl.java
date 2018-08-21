package com.lc.springcloud.service.impl;


import com.lc.springcloud.Constants;
import com.lc.springcloud.exception.CustomRunTimeException;
import com.lc.springcloud.http.dto.ResponseDTO;
import com.lc.springcloud.http.dto.req.IdDTO;
import com.lc.springcloud.pojo.UserInfo;
import com.lc.springcloud.repository.UserInfoRepository;
import com.lc.springcloud.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//import com.sykj.uusmart.service.PictureService;

/**
 * Created by Liang on 2016/12/23.
 */
@Service
@Transactional( propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT, rollbackFor = CustomRunTimeException.class)
public class UserInfoServiceImpl implements UserInfoService {

    private  Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public ResponseDTO updateInfo(IdDTO idDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(idDTO.getId() + " 号");
        userInfoRepository.save(userInfo);
        return new ResponseDTO(Constants.mainStatus.REQUEST_SUCCESS);
    }


}
