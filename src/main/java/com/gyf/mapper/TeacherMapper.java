package com.gyf.mapper;

import com.gyf.pojo.CourseTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 郭云飞
 * @date 2021/5/7-16:46
 * @Description TODO
 */
@Mapper
public interface TeacherMapper {
    List<CourseTable> getCourseTable(String teacherName);
}
