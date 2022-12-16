package com.example.trueclubrest.controller;

import com.example.trueclubrest.entity.AssignmentClass;
import com.example.trueclubrest.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trueclub")
public class MainController {

    @Autowired
    private AssignmentService service;

    @GetMapping("/get-all")
    public List<AssignmentClass> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<AssignmentClass> getRecordById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @PostMapping("/add-record")
    public AssignmentClass addRecord(@RequestBody AssignmentClass assignmentClass) {
        return service.insertRecord(assignmentClass);
    }

    @PutMapping("/update-record/{id}")
    public ResponseEntity<AssignmentClass> updateRecord(@PathVariable Long id,
                                                        @RequestBody AssignmentClass updatedRecord) {
        return service.updateRecord(updatedRecord, id);
    }

    @DeleteMapping("/delete-record/{id}")
    public String deleteRecord(@PathVariable Long id) {
        return service.deleteRecord(id);
    }

}
