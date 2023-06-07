package com.codeelevate.schoolservice.service;

import com.codeelevate.schoolservice.entity.School;
import com.codeelevate.schoolservice.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School updateStudent(Long id, School school) {
        School existingSchool = schoolRepository.findById(id).orElse(null);
        if (existingSchool != null) {
            existingSchool.setName(school.getName());
            existingSchool.setAddress(school.getAddress());
            return schoolRepository.save(existingSchool);
        }
        return null;
    }


    public void deleteStudent(Long id) {
        schoolRepository.deleteById(id);
    }
}
