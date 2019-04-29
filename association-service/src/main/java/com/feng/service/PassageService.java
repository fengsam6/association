package com.feng.service;

import com.feng.entity.Passage;
import com.feng.vo.PassagePageVo;
import com.feng.vo.PassageVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
public interface PassageService  {
    PassageVo getTopN(int n, Passage search);

    PageInfo<Passage> getPage(int pageNum, int pageSize, Passage search);
    PassagePageVo getPageWithTypeList(int pageNum, int pageSize, Integer passageTypeId);
    Passage getById(Serializable id);

    Passage add(Passage passage);

    Passage updateWithId(Passage passage);

    boolean deleteById(Serializable id);
}
