package com.feng.vo;

import com.feng.entity.Club;
import com.feng.entity.ClubType;
import com.feng.entity.File;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/5/3.
 */
@Data
public class ClubInfoVo extends Club {
    private ClubType clubType;
    private List<File> fileList;
}
