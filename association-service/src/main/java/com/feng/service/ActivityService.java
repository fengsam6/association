package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.Activity;
import com.feng.vo.ActivityPageVo;
import com.feng.vo.ActivityVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public interface ActivityService extends IService<Activity> {
    ActivityVo getTopN(int n, Activity search);

    PageInfo<Activity> getPage(int pageNum, int pageSize, Activity search);

    ActivityPageVo getPageWithTypeList(int pageNum, int pageSize, Integer activityTypeId);

    Activity getById(Serializable id);

    Activity add(Activity activity);

    Activity updateWithId(Activity activity);

    boolean deleteById(Serializable id);
}
