package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import projet.park.automobile.gestionparkautomobile.model.ActivityLog;
import projet.park.automobile.gestionparkautomobile.repository.ActivityLogRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ActivityServiceImpl implements ActivityRepositoryService{

    @Autowired
    ActivityLogRepository activityLogRepository;

    @Override
    public List<ActivityLog> findByVehicleId(Long vehicleId) {
        return List.of();
    }

    @Override
    public List<ActivityLog> findByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<ActivityLog> findByEntryTimeBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return List.of();
    }

    @Override
    public List<ActivityLog> findByExitTimeIsNull() {
        return List.of();
    }
}
