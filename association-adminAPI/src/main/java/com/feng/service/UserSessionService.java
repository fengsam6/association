package com.feng.service;

/**
 * 使用redis保存用户登录会话信息
 */
public interface UserSessionService {
    void saveUserSession(String token,int userId);

    int getUserId(String token);

    void removeUserSession(String token);

    void updateUserSession(String token);

    boolean isUserTokenExist(String token);
}
