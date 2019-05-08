package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.Club;
import com.feng.vo.ClubInfoVo;
import com.feng.vo.ClubPageVo;
import com.feng.vo.ClubVo;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-04-14
 */
public interface ClubService extends IService<Club> {
    ClubVo getTopN(int n, Club search);

    PageInfo<ClubInfoVo> getPage(int pageNum, int pageSize, Club search);

    ClubPageVo getPageWithTypeList(int pageNum, int pageSize, Integer clubTypeId);

    Club getById(Serializable id);

    Club add(Club club);

    Club updateWithId(Club club);

    boolean deleteById(Serializable id);
}
