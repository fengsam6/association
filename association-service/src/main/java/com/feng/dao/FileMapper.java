package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.entity.File;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public interface FileMapper extends BaseMapper<File> {
    Integer save(File file);
}
