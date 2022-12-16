package com.example.trueclubrest.service;

import com.example.trueclubrest.entity.AssignmentClass;
import com.example.trueclubrest.entity.ResourceNotFoundException;
import com.example.trueclubrest.repo.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AssignmentServiceImpl implements AssignmentService{

    @Autowired
    private AssignmentRepo repo;

    @Override
    public ResponseEntity<AssignmentClass> getRecordById(Long id) {
        AssignmentClass a = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No record with id: " + id));
        return ResponseEntity.ok(a);
    }

    @Override
    public List<AssignmentClass> getAllRecords() {
        return repo.findAll();
    }

    @Override
    public ResponseEntity<AssignmentClass> updateRecord(AssignmentClass updatedRecord, Long id) {
        AssignmentClass a = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No record with id: " + id));

        if(!Objects.isNull(updatedRecord.getState()) && !(a.getState().equals(updatedRecord.getState()))) {
            a.setState(updatedRecord.getState());
        }

        if(!Objects.isNull(updatedRecord.getAddress()) && !(a.getAddress().equals(updatedRecord.getAddress()))) {
            a.setAddress(updatedRecord.getAddress());
        }

        if(!Objects.isNull(updatedRecord.getName()) && !(a.getName().equals(updatedRecord.getName()))) {
            a.setName(updatedRecord.getName());
        }

        if(!Objects.isNull(updatedRecord.getPincode()) && !(a.getPincode().equals(updatedRecord.getPincode()))) {
            a.setPincode(updatedRecord.getPincode());
        }

        AssignmentClass saved = repo.save(a);
        return ResponseEntity.ok(saved);
    }

    @Override
    public AssignmentClass insertRecord(AssignmentClass record) {
        record.setRow_creation_timestamp(new Timestamp(System.currentTimeMillis()));
        return repo.save(record);
    }

    @Override
    public String deleteRecord(Long id) {
        AssignmentClass a = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No record with id: " + id));

        repo.delete(a);
        return "DELETED";
    }
}
