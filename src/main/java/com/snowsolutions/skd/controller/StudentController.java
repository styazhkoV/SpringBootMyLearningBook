package com.snowsolutions.skd.controller;

import com.snowsolutions.skd.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/students")

public class StudentController {
    Student student;
}
