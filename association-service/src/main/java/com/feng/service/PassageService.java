package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.Passage;

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
public interface PassageService  {
    List<Passage> getTopByType(int type, int num);

    List<Passage> getPage(int pageNum, int pageSize, Passage search);

    Passage getById(Serializable id);

    Passage add(Passage passage);

    Passage updateWithId(Passage passage);

    boolean deleteById(Serializable id);
}
