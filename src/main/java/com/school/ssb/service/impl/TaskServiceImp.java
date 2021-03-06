package com.school.ssb.service.impl;

import com.school.ssb.bean.Task;
import com.school.ssb.mapperDao.TaskMapper;
import com.school.ssb.service.Taskservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TaskServiceImp implements Taskservice {

    @Autowired
    TaskMapper taskMapper;
    
    /**
     *
     * @Method : getRecommendList
     * @Description :获取推荐列表，暂时按时间倒序排序后续加位置
     * @param task : 
     * @return : java.util.List<com.school.ssb.bean.Task>
     * @author : xk
     * @CreateDate : 2019-05-19 21:29:03
     * 
     */
    @Override
    public List<Task> getRecommendList(Task task) {
        List<Task> taskList = taskMapper.findTaskRecommend(task);
        return taskList;
    }

    /**
     *
     * @Method : getTasksByParams
     * @Description : 获取各个类型的任务列表
     * @param task : 
     * @return : java.util.List<com.school.ssb.bean.Task>
     * @author : xk
     * @CreateDate : 2019-05-19 21:29:43
     * 
     */
    @Override
    public List<Task> getTasksType(Task task) {
        return taskMapper.selectTasksByParam(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> doTask(Task task) {
        Map<String,Object> map = new HashMap<String,Object>();
        //查找该任务是否已经被抢
        Task nowTask = taskMapper.selectByPrimaryKey(task.getId());
        if(nowTask.getTaskStatus() == 0){
            task.setTaskStatus(1);
            taskMapper.updateByPrimaryKeySelective(task);
            map.put("api_status", "1");
        }
        return map;
    }

    @Override
    public Map<String, Object> publicTask(Task task) {
        Map<String, Object> map = new HashMap<>();
        int result = taskMapper.insertSelective(task);
        map.put("api_status", result);
        return map;
    }

}
