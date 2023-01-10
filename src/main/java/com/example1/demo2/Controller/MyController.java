package com.example1.demo2.Controller;


import com.example1.demo2.Service.CourseServiceImpl;
import com.example1.demo2.entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    private final CourseServiceImpl courseService;

    public MyController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/test")
    public String courses(){
        return "Ävailable Courses";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Optional<Course> getCourseById(@PathVariable String courseID){
        return this.courseService.getCourseById(Long.parseLong(courseID));
    }
    @PostMapping("/courses")
    public Course AddCourse(@RequestBody Course course){
        return this.courseService.addNewCourse(course);
    }

}
