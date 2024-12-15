package projet.park.automobile.gestionparkautomobile.service;

import projet.park.automobile.gestionparkautomobile.model.ActivityLog;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepositoryService  {

    // Trouver tous les journaux d'activités pour un véhicule donné
    List<ActivityLog> findByVehicleId(Long vehicleId);

    // Trouver tous les journaux d'activités pour un utilisateur donné
    List<ActivityLog> findByUserId(Long userId);

    // Trouver tous les journaux d'activités dans une plage de temps donnée
    List<ActivityLog> findByEntryTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    // Trouver les journaux d'activités actifs (sans exitTime défini)
    List<ActivityLog> findByExitTimeIsNull();
}
