package com.example.parkingmanegement.parkingmanagement.services;

import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;
import com.example.parkingmanegement.parkingmanagement.entity.User;

import java.util.List;

public interface ActivityLogService {
    //    Ajout et mise à jour
    ActivityLog addActivityLog(ActivityLog activityLog);
    ActivityLog updateActivityLog(ActivityLog activityLog);

    //    Suppression
    void deleteActivityLog(ActivityLog activityLog);
    void deleteActivityLogById(Long id);

    //    Recuperer
    ActivityLog getActivityLogById(Long id);
    List<ActivityLog> getActivityLogAlls();
}
