package com.feng.service.impl;

import com.feng.entity.User;
import com.feng.dao.UserMapper;
import com.feng.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-03-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
