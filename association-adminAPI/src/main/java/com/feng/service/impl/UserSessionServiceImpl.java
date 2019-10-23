package com.feng.service.impl;

import com.feng.constants.AppConstant;
import com.feng.service.RedisOperatorService;
import com.feng.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserSessionServiceImpl implements UserSessionService {
    @Autowired
    private RedisOperatorService redisOperatorService;
    private String userTokenPrefix = AppConstant.userTokenPrefix;
    private int sessionTime = AppConstant.loginTokenTime;

    @Override
    public void saveUserSession(String token, int userId) {
        redisOperatorService.setValue(userTokenPrefix + token, userId+"", sessionTime);
    }

    @Override
    public int getUserId(String token) {
      String userIdStr =  redisOperatorService.getValue(userTokenPrefix+token);
      int userId=0;
      if(!StringUtils.isEmpty(userIdStr)){
          userId=Integer.parseInt(userIdStr);
      }
        return userId;
    }

    @Override
    public void removeUserSession(String token) {
        redisOperatorService.deleteKey(userTokenPrefix + token);
    }

    @Override
    public void updateUserSession(String token) {
        redisOperatorService.expireKey(userTokenPrefix + token, sessionTime);
    }

    @Override
    public boolean isUserTokenExist(String token) {
        return redisOperatorService.isExists(userTokenPrefix + token);
    }
}
