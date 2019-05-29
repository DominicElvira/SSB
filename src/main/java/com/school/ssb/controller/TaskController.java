package com.school.ssb.controller;

import com.school.ssb.bean.PageEntity;
import com.school.ssb.bean.Task;
import com.school.ssb.bean.User;
import com.school.ssb.service.impl.TaskServiceImp;
import com.school.ssb.service.impl.UserServiceImp;
import com.sun.jmx.snmp.tasks.TaskServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TaskController {
    @Autowired
    private TaskServiceImp taskService;

    @Autowired
    private UserServiceImp userServiceImp;

    /**
     *
     * @Method : getRecommendTask
     * @Description :获取推荐列表
     * @param task : 
     * @return : org.springframework.http.ResponseEntity
     * @author : xk
     * @CreateDate : 2019-05-19 21:31:31
     * 
     */
    @PostMapping("/g/recommendTask")
    public ResponseEntity getRecommendTask(@RequestBody Task task) {
        List<Task> taskList = taskService.getRecommendList(task);
        return new ResponseEntity(new PageEntity<>(taskList), HttpStatus.OK);
    }

    /**
     *
     * @Method : getTasksByParam
     * @Description :获取各个类型的
     * @param task : 
     * @return : org.springframework.http.ResponseEntity
     * @author : xk
     * @CreateDate : 2019-05-19 21:32:35
     * 
     */
    @PostMapping("/g/tasksByType")
    public ResponseEntity getTasksByType(@RequestBody Task task) {
        List<Task> taskList = taskService.getTasksType(task);
        return new ResponseEntity(new PageEntity<>(taskList), HttpStatus.OK);
    }

    /**
     * 获取任务详情
     * @param task
     * @return
     */
    @PostMapping(value = "/g/getTask")
    public Task getTask(@RequestBody Task task) {
        Task task1 = taskService.getTask(task.getId());
        //获取发布人信息
        User user1 = userServiceImp.selectById(task1.getUserid());
        task1.setUserName(user1.getNickName());
        task1.setUserImgSrc(user1.getImgSrc());

        if(task1.getExecuteUserid() != null){
            User executeUser = userServiceImp.selectById(task1.getExecuteUserid());
            task1.setExecuteUserName(executeUser.getNickName());
            task1.setExecuteUserImgSrc(executeUser.getImgSrc());
        }
        return task1;
    }

    /**
     * 用户抢单
     * @param task
     * @return
     */
    @PostMapping(value = "/g/doTask")
    public Map<String,Object> doTask(@RequestBody Task task) {
        Map<String,Object> map = new HashMap<String,Object>();
        //map = taskService.doTask(task);
        try{
            map = taskService.doTask(task);
        }catch(Exception e){
            e.printStackTrace();
            map.put("api_status", "-1");
            map.put("api_errormsg", "catch exception : " + e.getMessage());
        }
        return map;
    }
}
