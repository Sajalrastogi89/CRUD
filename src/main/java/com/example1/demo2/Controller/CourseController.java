package com.example1.demo2.Controller;


import com.example1.demo2.Service.Impl.CourseServiceImpl;
import com.example1.demo2.payloads.APIResponse;
import com.example1.demo2.payloads.CourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }



    //get the courses
    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getCourses(){
       List<CourseDTO>  courseDTOS=this.courseService.getAllCourses();
       return new ResponseEntity<>(courseDTOS,HttpStatus.OK);

    }

    @GetMapping("/{courseID}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer courseID){
        try{
       CourseDTO courseDTO=this.courseService.getCourseById(courseID);
       return new ResponseEntity<>(courseDTO,HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/")
    public ResponseEntity<CourseDTO> AddCourse(@RequestBody CourseDTO courseDTO){
       CourseDTO courseDTO1= this.courseService.addNewCourse(courseDTO);
       return new ResponseEntity<>(courseDTO1,HttpStatus.OK);
    }


    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO,@PathVariable Integer courseId){
       CourseDTO courseDTO1=this.courseService.updateExistingCourse(courseDTO,courseId);
       return ResponseEntity.ok(courseDTO1);
    }
    @DeleteMapping("/{courseID}")

    public ResponseEntity<APIResponse> deleteCourse(@PathVariable Integer courseID) {
        try{
    this.courseService.delete(courseID);
    return new ResponseEntity<APIResponse>(new APIResponse("Deleted",true),HttpStatus.OK);}
        catch(Exception e){
        return new ResponseEntity<>(new APIResponse("Deleted",false),HttpStatus.OK);
        }
    }


}

