package com.feng.constants;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Created by rf on 2019/5/4.
 */
@Getter
@Component
public class AppConstant {
    private String userSessionPrefix="userSession:";
    private String userToken="userToken:";
}
