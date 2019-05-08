package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.entity.Club;
import com.feng.entity.Club;
import com.feng.vo.ClubInfoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rf
 * @since 2019-04-14
 */
public interface ClubMapper extends BaseMapper<Club> {
    List<ClubInfoVo> findClub(Club club);

    ClubInfoVo getInfoById(Integer id);
}
