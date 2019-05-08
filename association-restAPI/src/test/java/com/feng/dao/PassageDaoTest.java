package com.feng.dao;

import com.feng.entity.Passage;
import com.feng.service.PassageService;
import com.feng.vo.PassageInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by rf on 2019/3/4.
 */
@RunWith(SpringRunner.class)
@MapperScan("com.feng.dao")
@SpringBootTest
public class PassageDaoTest {
    @Autowired
    private PassageService passageService;

    @Test
    public void get() {
     PassageInfoVo passage = passageService.getInfoById(46);
     System.out.println(passage.toString());
    }
}
