package com.example.parkingmanegement.parkingmanagement.service;


import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;

import com.example.parkingmanegement.parkingmanagement.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service pour gérer les journaux d'activités.
 */
@Service
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    /**
     * Constructeur pour injecter le repository.
     * @param activityLogRepository Repository des journaux d'activités.
     */


    /**
     * Ajouter un journal d'activité.
     * @param action Action effectuée.
     * @param performedBy Auteur de l'action.
     * @return Journal d'activité enregistré.
     */
    public ActivityLog addActivity(String action, String performedBy) {
        ActivityLog log = new ActivityLog();
        log.setAction(action);
        log.setPerformedBy(performedBy);
        log.setTimestamp(LocalDateTime.now());

        return (ActivityLog) activityLogRepository.save(log);
//        return (ActivityLog) activityLogRepository.save(log);
    }

    /**
     * Récupérer tous les journaux d'activités.
     *
     * @return Liste des journaux d'activités.
     */
    public List getAllActivities() {
        return activityLogRepository.findAll();
    }

    /**
     * Supprimer un journal d'activité par ID.
     * @param id ID du journal à supprimer.
     */
    public void deleteActivityLog(Long id) {
        activityLogRepository.deleteById(id);
    }


}
