package com.feng.vo;

import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/4/18.
 */
@Data
public class PassageVo{
    private PassageType passageType;
    private List<Passage> passageList;

    public PassageVo(PassageType passageType, List<Passage> passageList) {
        this.passageType = passageType;
        this.passageList = passageList;
    }

    public PassageVo() {
    }
}
