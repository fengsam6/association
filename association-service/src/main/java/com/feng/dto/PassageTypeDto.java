package com.feng.dto;

import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import lombok.Data;

/**
 * Created by rf on 2019/5/8.
 */
@Data
public class PassageTypeDto extends Passage{
    private PassageType passageType;
}
