package com.feng.service.impl;

import com.feng.entity.Student;
import com.feng.dao.StudentMapper;
import com.feng.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-04-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
