package com.feng.vo;

import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/4/18.
 */
@Data
public class PassagePageVo {
    private PassageType passageType;
    private PageInfo<Passage> passagePageInfo;

    public PassagePageVo(PassageType passageType, PageInfo<Passage> passagePageInfo) {
        this.passageType = passageType;
        this.passagePageInfo = passagePageInfo;
    }

    public PassagePageVo() {
    }
}
