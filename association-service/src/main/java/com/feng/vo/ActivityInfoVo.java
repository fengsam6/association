package com.feng.vo;

import com.feng.entity.File;
import com.feng.entity.Activity;
import com.feng.entity.ActivityType;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/5/3.
 */
@Data
public class ActivityInfoVo extends Activity {
    private ActivityType activityType;
    private List<File> fileList;
}
