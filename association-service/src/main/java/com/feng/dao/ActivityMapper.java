package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.entity.Activity;
import com.feng.entity.Activity;
import com.feng.vo.ActivityInfoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public interface ActivityMapper extends BaseMapper<Activity> {
    List<ActivityInfoVo> findActivity(Activity activity);

    ActivityInfoVo getInfoById(Integer id);
}
