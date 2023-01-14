package com.example1.demo2.Service;


import com.example1.demo2.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getAllCourses();

    Optional<Course> getCourseById(Long courseID);

    Course addNewCourse(Course course);

    Course updateExistingCourse(Course course);

    void delete(long id);
}
