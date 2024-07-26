package com.khrd.schoolmicroservice;

import com.khrd.schoolmicroservice.model.School;
import com.khrd.schoolmicroservice.model.SchoolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school){
        return schoolRepository.save(school);
    }
    public List<School> fetchSchools(){
        return schoolRepository.findAll();
    }
    public School fetchSchoolById(int id){
        return schoolRepository.findById(id).orElse(null);
    }

    public School updateSchoolById(Integer id, SchoolRequest updatedSchool) {
        Optional<School> optionalSchool = schoolRepository.findById(id);

        if (optionalSchool.isPresent()) {
            School uSchool = optionalSchool.get();
            uSchool.setSchoolName(updatedSchool.getSchoolName());
            uSchool.setLocation(updatedSchool.getLocation());
            uSchool.setPrincipalName(updatedSchool.getPrincipalName());


            return schoolRepository.save(uSchool);
        } else {
            return null;
        }
    }

}
