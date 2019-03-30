package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.entity.Passage;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
public interface PassageMapper extends BaseMapper<Passage> {
    List<Passage> getByTypeID();
}
