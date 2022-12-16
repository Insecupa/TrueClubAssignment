package com.example.trueclubrest.repo;

import com.example.trueclubrest.entity.AssignmentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<AssignmentClass, Long> {
}
