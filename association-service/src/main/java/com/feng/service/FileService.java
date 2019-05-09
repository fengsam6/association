package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.File;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public interface FileService extends IService<File> {
    Integer save(File file);

    PageInfo<File> getPage(int pageNum, int pageSize, File search);
}
