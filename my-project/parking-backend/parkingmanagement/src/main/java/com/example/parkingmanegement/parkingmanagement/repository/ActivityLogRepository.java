package com.example.parkingmanegement.parkingmanagement.repository;

import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour gérer les opérations CRUD des journaux d'activités.
 */
@Repository
public interface ActivityLogRepository extends JpaRepository <ActivityLog , Long>{
}
