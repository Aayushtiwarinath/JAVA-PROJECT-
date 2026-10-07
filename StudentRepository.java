package com.aayu.studentcrud.repository;

import com.aayu.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(String name, String course);
}
