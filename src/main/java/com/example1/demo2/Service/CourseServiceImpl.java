package com.example1.demo2.Service;

import com.example1.demo2.Dao.CourseDao;
import com.example1.demo2.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService{


    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }


    @Override
    public List<Course> getAllCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseID) {


        return this.courseDao.findById(courseID);
    }

    @Override
    public Course addNewCourse(Course course) {
        this.courseDao.save(course);
        return  course;
    }

    @Override
    public Course updateExistingCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public void delete(long id) {
        this.courseDao.deleteById(id);
    }
}
