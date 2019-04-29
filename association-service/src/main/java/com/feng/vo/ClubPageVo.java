package com.feng.vo;

import com.feng.entity.Club;
import com.feng.entity.ClubType;
import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * Created by rf on 2019/4/18.
 */
@Data
public class ClubPageVo {
    private ClubType clubType;
    private PageInfo<Club> clubPageInfo;

    public ClubPageVo(ClubType clubType, PageInfo<Club> clubPageInfo) {
        this.clubType = clubType;
        this.clubPageInfo = clubPageInfo;
    }

    public ClubPageVo() {
    }

}
