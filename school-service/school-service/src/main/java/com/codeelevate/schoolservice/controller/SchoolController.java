package com.codeelevate.schoolservice.controller;

import com.codeelevate.schoolservice.entity.School;
import com.codeelevate.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @PutMapping("{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateStudent(id, school);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
        schoolService.deleteStudent(id);
    }

}
