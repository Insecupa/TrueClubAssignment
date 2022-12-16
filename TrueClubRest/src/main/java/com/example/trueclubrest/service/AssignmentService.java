package com.example.trueclubrest.service;

import com.example.trueclubrest.entity.AssignmentClass;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignmentService {
    public ResponseEntity<AssignmentClass> getRecordById(Long id);
    List<AssignmentClass> getAllRecords();
    ResponseEntity<AssignmentClass> updateRecord(AssignmentClass updatedRecord, Long id);
    AssignmentClass insertRecord(AssignmentClass record);
    String deleteRecord(Long id);
}
