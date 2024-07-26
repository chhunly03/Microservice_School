package com.khrd.schoolmicroservice.controller;

import com.khrd.schoolmicroservice.SchoolService;
import com.khrd.schoolmicroservice.model.School;
import com.khrd.schoolmicroservice.model.SchoolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school){
        return schoolService.addSchool(school);
    }
    @GetMapping
    public List<School> fetchSchools(){
        return  schoolService.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable int id){
        return schoolService.fetchSchoolById(id);
    }

    @PutMapping("/{id}")
    public School updateSchoolById(@PathVariable Integer id, @RequestBody SchoolRequest updatedSchool) {
        return schoolService.updateSchoolById(id, updatedSchool);
    }
}