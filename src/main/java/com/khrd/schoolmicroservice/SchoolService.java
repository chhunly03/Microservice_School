package com.khrd.schoolmicroservice;

import com.khrd.schoolmicroservice.model.School;
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

    public School updateSchoolById(Integer id, School updatedSchool) {
        Optional<School> optionalSchool = schoolRepository.findById(id);

        if (optionalSchool.isPresent()) {
            School existingSchool = optionalSchool.get();

            // Create a new School entity with the updated ID
            School newSchool = new School();
            newSchool.setId(updatedSchool.getId());
            newSchool.setSchoolName(updatedSchool.getSchoolName());
            newSchool.setLocation(updatedSchool.getLocation());
            newSchool.setPrincipalName(updatedSchool.getPrincipalName());

            // Save the new entity
            School savedSchool = schoolRepository.save(newSchool);

            // Delete the old entity
            schoolRepository.delete(existingSchool);

            return savedSchool;
        } else {
            return null;
        }
    }

}
