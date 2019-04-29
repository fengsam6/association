package com.feng.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.StudentMapper;
import com.feng.entity.Student;
import com.feng.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-04-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
