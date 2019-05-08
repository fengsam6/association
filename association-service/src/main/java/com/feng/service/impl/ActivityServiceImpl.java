package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.ActivityMapper;
import com.feng.dao.ActivityTypeMapper;
import com.feng.dao.FileMapper;
import com.feng.entity.Activity;
import com.feng.entity.ActivityType;
import com.feng.entity.File;
import com.feng.enums.ErroEnum;
import com.feng.exception.BusinessException;
import com.feng.service.ActivityService;
import com.feng.vo.ActivityInfoVo;
import com.feng.vo.ActivityPageVo;
import com.feng.vo.ActivityVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityTypeMapper activityTypeMapper;
    @Autowired
    private FileMapper fileMapper;

    public ActivityVo getTopN(int n, Activity search) {
        ActivityType activityType = null;
        Wrapper<Activity> activityWrapper = new EntityWrapper<>();
        if (search.getActivityTypeId() != null && search.getActivityTypeId() != 0) {
            activityWrapper.eq("activity_type_id", search.getActivityTypeId());
            activityType = activityTypeMapper.selectById(search.getActivityTypeId());
        }
        activityWrapper.orderBy("apply_time", false);
        PageHelper.startPage(1, n);
        List<Activity> activityList = activityMapper.selectList(activityWrapper);
        return new ActivityVo(activityType, activityList);
    }

    @Override
    public PageInfo<ActivityInfoVo> getPage(int pageNum, int pageSize, Activity search) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivityInfoVo> activityList = activityMapper.findActivity(search);
        return new PageInfo<>(activityList);
    }

    @Override
    public ActivityPageVo getPageWithTypeList(int pageNum, int pageSize, Integer activityTypeId) {
        ActivityType activityType = null;
        Wrapper<Activity> activityWrapper = new EntityWrapper<>();
        if (activityTypeId != null) {
            activityWrapper.eq("activity_type_id", activityTypeId);
            activityType = activityTypeMapper.selectById(activityTypeId);
        }
        activityWrapper.orderBy("apply_time", false);
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> activityList = activityMapper.selectList(activityWrapper);
        return new ActivityPageVo(activityType, new PageInfo<>(activityList));
    }

    @Override
    @Cacheable(value = "activity")
    public ActivityInfoVo getById(Serializable id) {
        Activity activity = activityMapper.selectById(id);
        if (activity == null) {
            throw new BusinessException(ErroEnum.BUSINESS_EXCEPTION.setMsg("活动不存在"));
        }
        ActivityInfoVo activityInfoVo = new ActivityInfoVo();
        BeanUtils.copyProperties(activity, activityInfoVo);
        File file =null;
        if (activity.getFileId() != 0) {
            file = fileMapper.selectById(activity.getFileId());
        }else {
            return activityInfoVo;
        }
        List<File> fileList = new ArrayList<>();
        if(file!=null){
            fileList.add(file);
            activityInfoVo.setFileList(fileList);
        }

        return activityInfoVo;
    }

    @Override
//    @CachePut(value = "activity", key = "#activity.id")
    public Activity add(Activity activity) {
        activityMapper.insert(activity);
        return activity;
    }

    @Override
    @CacheEvict(value = "activity", key = "#id")
    public boolean deleteById(Serializable id) {
        Assert.notNull(id, "活动id不能为空");
        activityMapper.deleteById(id);
        return true;
    }

    @Override
    @CachePut(value = "activity", key = "#activity.id")
    public ActivityInfoVo updateWithId(ActivityInfoVo activity) {
        activityMapper.updateById(activity);
        return activity;
    }
}
