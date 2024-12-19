package com.example.parkingmanegement.parkingmanagement.services;


import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;

import com.example.parkingmanegement.parkingmanagement.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour gérer les journaux d'activités.
 */
@Service
public class ActivityLogServicesImpl implements ActivityLogService{

    @Autowired
    ActivityLogRepository activityLogRepository;

    @Override
    public ActivityLog addActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public ActivityLog updateActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteActivityLog(ActivityLog activityLog) {
        activityLogRepository.delete(activityLog);
    }

    @Override
    public void deleteActivityLogById(Long id) {
        activityLogRepository.deleteById(id);
    }

    @Override
    public ActivityLog getActivityLogById(Long id) {
        return activityLogRepository.findById(id).get();
    }

    @Override
    public List<ActivityLog> getActivityLogAlls() {
        return activityLogRepository.findAll();
    }
}
