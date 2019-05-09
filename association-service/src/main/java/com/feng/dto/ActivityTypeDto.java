package com.feng.dto;

import com.feng.entity.Activity;
import com.feng.entity.Activity;
import com.feng.entity.ActivityType;
import lombok.Data;

/**
 * Created by rf on 2019/5/8.
 */
@Data
public class ActivityTypeDto extends Activity{
    private ActivityType activityType;
}
