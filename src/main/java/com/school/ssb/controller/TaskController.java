package com.school.ssb.controller;

import com.school.ssb.bean.PageEntity;
import com.school.ssb.bean.Task;
import com.school.ssb.service.impl.TaskServiceImp;
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
