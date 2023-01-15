package com.example1.demo2.Repositories;
import com.example1.demo2.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {
}
