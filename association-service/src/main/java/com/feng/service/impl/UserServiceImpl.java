package com.feng.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.UserMapper;
import com.feng.entity.User;
import com.feng.enums.ExceptionEnum;
import com.feng.exception.BusinessException;
import com.feng.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserPage(int num, int size) {
        PageHelper.startPage(num, size);
        return userMapper.selectList(null);
    }

    @Override
    public User login(User user) {
        userMapper.selectByMap(null);
        return null;
    }

    @Override
    public User add(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User updateById(User user) {
        userMapper.updateById(user);
        return user;
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    public User getById(Serializable id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ExceptionEnum.BUSINESS_EXCEPTION.setMsg("该用户不存在"));
        }
        return user;
    }

    @Override
    @CacheEvict(value = "user",key = "#id")
    public void DeleteById(Serializable id) {
        userMapper.deleteById(id);
    }

    @Override
    public User register(User user, String rePassWord) {
        return null;
    }
}
