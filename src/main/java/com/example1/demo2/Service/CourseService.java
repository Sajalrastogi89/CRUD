package com.example1.demo2.Service;


import com.example1.demo2.entities.Course;
import com.example1.demo2.payloads.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    //get All Courses
     List<CourseDTO> getAllCourses();

    //Get Course by Id

    CourseDTO getCourseById(Integer courseID);

    //Create new Course
    CourseDTO addNewCourse(CourseDTO courseDTO);

    //Update Course
    CourseDTO updateExistingCourse(CourseDTO courseDTO,Integer courseId);
    //Delete a course

    void delete(Integer id);
}
