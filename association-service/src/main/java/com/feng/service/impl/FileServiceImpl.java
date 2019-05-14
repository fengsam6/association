package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.FileMapper;
import com.feng.entity.File;
import com.feng.entity.File;
import com.feng.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
@Autowired
    private FileMapper fileMapper;
    @Override
    public Integer save(File file) {
        return fileMapper.save(file);
    }
    public PageInfo<File> getPage(int pageNum, int pageSize, File search) {
        Wrapper<File> fileWrapper = new EntityWrapper<>();
        if (search != null && search.getFileTypeId() != null) {
            fileWrapper.eq("file_type_id", search.getFileTypeId());
        }
        if (search != null && !StringUtils.isEmpty(search.getFileName())) {
            fileWrapper.like("file_name", search.getFileName());
        }
        fileWrapper.orderBy("create_time",false);
        PageHelper.startPage(pageNum, pageSize);
        List<File> fileList = fileMapper.selectList(fileWrapper);
        return new PageInfo<>(fileList);
    }
}
