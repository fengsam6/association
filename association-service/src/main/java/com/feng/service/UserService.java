package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
public interface UserService{
    List<User> getUserPage(int size,int num);

    User login(User user);

    User add(User user);

    User updateById(User user);

    User getById(Serializable id);

   void  DeleteById(Serializable id);

    User register(User user,String rePassWord);
}
