package com.feng.vo;

import com.feng.entity.User;
import lombok.Data;

/**
 * Created by rf on 2019/4/30.
 */
@Data
public class LoginUserVo extends User{
    private String code;
}
