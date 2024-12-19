package com.example.parkingmanegement.parkingmanagement.controller;

import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;
import com.example.parkingmanegement.parkingmanagement.services.ActivityLogServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API REST pour gérer les journaux d'activités.
 */
@RestController
@RequestMapping("/api/activity-logs")
public class ActivityController {

    private final ActivityLogServices activityLogServices;

    /**
     * Constructeur pour injecter le service.
     * @param activityLogServices Service des journaux d'activités.
     */

    public ActivityController(ActivityLogServices activityLogServices) {
        this.activityLogServices = activityLogServices;
    }

    /**
     * Récupérer tous les journaux d'activités.
     * @return Liste des journaux d'activités.
     */
    @GetMapping
    public ResponseEntity<List<ActivityLog>> getAllActivities() {
        List<ActivityLog> logs = activityLogServices.getAllActivities();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    /**
     * Ajouter un journal d'activité.
     * @param log Détails de l'activité.
     * @return Journal d'activité ajouté.
     */
    @PostMapping
    public ResponseEntity<ActivityLog> addActivity(@RequestBody ActivityLog log) {
        ActivityLog savedLog = activityLogServices.addActivity(log.getAction(), log.getPerformedBy());
        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    /**
     * Supprimer un journal d'activité par ID.
     * @param id ID du journal à supprimer.
     * @return Réponse HTTP sans contenu.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityLog(@PathVariable Long id) {
        activityLogServices.deleteActivityLog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
