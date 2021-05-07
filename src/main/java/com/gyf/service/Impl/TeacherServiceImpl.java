package com.gyf.service.Impl;

import com.gyf.mapper.TeacherMapper;
import com.gyf.pojo.CourseTable;
import com.gyf.result.ResultObject;
import com.gyf.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭云飞
 * @date 2021/5/7-16:56
 * @Description TODO
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public ResultObject getCourseTable(String teacherName) {
        List<CourseTable> courseTableList=teacherMapper.getCourseTable(teacherName);
        return new ResultObject(200,"查询成功",courseTableList);
    }
}
