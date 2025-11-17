package com.ali.skeletonV1.controller;


import com.ali.skeletonV1.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
}
