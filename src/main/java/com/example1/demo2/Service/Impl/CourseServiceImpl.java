package com.example1.demo2.Service.Impl;

import com.example1.demo2.Repositories.CourseDao;
import com.example1.demo2.Service.CourseService;
import com.example1.demo2.entities.Course;
import com.example1.demo2.exceptions.ResourceNotFoundException;
import com.example1.demo2.payloads.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {

private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> list=this.courseDao.findAll();
        return list.stream().map((course)->courseToDTO(course)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Integer courseID) {
       Course course= this.courseDao.findById(courseID).orElseThrow(()->new ResourceNotFoundException("Course","Id",courseID));
    return courseToDTO(course);
    }

    @Override
    public CourseDTO addNewCourse(CourseDTO courseDTO) {
        Course course=dtoToCourse(courseDTO);
       Course createdCourse= this.courseDao.save(course);

        return courseToDTO(createdCourse);
    }

    @Override
    public CourseDTO updateExistingCourse(CourseDTO courseDTO, Integer courseId) {
Course course=this.courseDao.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course","Id",courseId));
course.setTitle(courseDTO.getTitle());
course.setDescription(courseDTO.getDescription());
Course updatedCourse=this.courseDao.save(course);
        return courseToDTO(updatedCourse);
    }

    @Override
    public void delete(Integer id) {
Course course=this.courseDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Course","Id",id));
        this.courseDao.delete(course);

    }

    public CourseDTO courseToDTO(Course course){
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        return  courseDTO;
    }

    public Course dtoToCourse(CourseDTO courseDTO){
        Course course=new Course();
        course.setId(courseDTO.getId());
        course.setTitle(courseDTO.getDescription());
        course.setDescription(courseDTO.getDescription());
        return course;
    }
}
