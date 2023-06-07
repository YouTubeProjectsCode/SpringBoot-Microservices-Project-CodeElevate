package com.ecodelevate.teacherservice.service;

import com.ecodelevate.teacherservice.entity.Teacher;
import com.ecodelevate.teacherservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            existingTeacher.setName(teacher.getName());
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
