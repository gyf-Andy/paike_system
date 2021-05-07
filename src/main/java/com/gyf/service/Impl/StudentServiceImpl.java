package com.gyf.service.Impl;

import com.gyf.mapper.StudentMapper;
import com.gyf.pojo.CourseTable;
import com.gyf.result.ResultObject;
import com.gyf.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭云飞
 * @date 2021/5/7-16:00
 * @Description TODO
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public ResultObject getCourseTable(String faculty) {
        List<CourseTable> courseTableList=studentMapper.getCourseTable(faculty);
        return new ResultObject(200,"查询成功",courseTableList);
    }
}
