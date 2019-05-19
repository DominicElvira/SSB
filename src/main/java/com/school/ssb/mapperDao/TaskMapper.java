package com.school.ssb.mapperDao;

import com.school.ssb.bean.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> findTaskRecommend(Task record);

    List<Task> selectTasksByParam(Task record);
}