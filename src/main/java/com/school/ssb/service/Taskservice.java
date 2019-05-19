package com.school.ssb.service;

import com.school.ssb.bean.Task;

import java.util.List;
import java.util.Map;

/**
 *
 * @Project : 
 * @Package : com.school.ssb.service
 * @Class : Taskservice
 * @Description : 
 * @author : xk
 * @CreateDate : 2019-05-19 16:45:07
 * @version : V1.0.0
 * @Copyright : xk All rights reserved.
 * @Reviewed : 
 * @UpateLog :    Name    Date    Reason/Contents
 *             ---------------------------------------
 * 
 */
public interface Taskservice {
    public List<Task> getRecommendList(Task task);

    public List<Task> getTasksType(Task task);
}
