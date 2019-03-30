package com.feng.service.impl;

import com.feng.dao.PassageMapper;
import com.feng.entity.Passage;
import com.feng.enums.ExceptionEnum;
import com.feng.exception.BusinessException;
import com.feng.service.PassageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
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
public class PassageServiceImpl  implements PassageService {
    @Autowired
    private PassageMapper passageMapper;

    @Override
    public List<Passage> getTopByType(int type, int num) {
//passageMapper
        return null;
    }

    @Override
    public List<Passage> getPage(int pageNum, int pageSize, Passage search) {
        PageHelper.offsetPage(pageNum,pageSize);
        List<Passage> passageList =  passageMapper.selectList(null);
        return passageList;
    }

    @Override
    @Cacheable(value = "passage")
    public Passage getById(Serializable id) {
      Passage passage =  passageMapper.selectById(id);
      if(passage==null){
          throw new BusinessException(ExceptionEnum.BUSINESS_EXCEPTION.setMsg("文章不存在"));
      }
        return passage;
    }

    @Override
//    @CachePut(value = "passage", key = "#passage.id")
    public Passage add(Passage passage) {
        passageMapper.insert(passage);
        return passage;
    }

    @Override
    @CacheEvict(value = "passage",key = "#id")
    public boolean deleteById(Serializable id) {
        Assert.notNull(id,"文章id不能为空");
        passageMapper.deleteById(id);
        return true;
    }

    @Override
    @CachePut(value = "passage", key = "#passage.id")
    public Passage updateWithId(Passage passage) {
        passageMapper.updateById(passage);
        return passage;
    }
}
