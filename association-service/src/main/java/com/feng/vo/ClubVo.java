package com.feng.vo;

import com.feng.entity.Club;
import com.feng.entity.ClubType;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/4/18.
 */
@Data
public class ClubVo {
    private ClubType clubType;
    private List<Club> clubList;

    public ClubVo(ClubType clubType, List<Club> clubList) {
        this.clubType = clubType;
        this.clubList = clubList;
    }
}
