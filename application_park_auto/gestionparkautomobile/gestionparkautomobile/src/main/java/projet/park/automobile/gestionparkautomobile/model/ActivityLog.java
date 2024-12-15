package projet.park.automobile.gestionparkautomobile.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/*
  Classe  Journal des activités
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TABLE_ACTIVITE")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivity;



    @Column(nullable = false)
    private LocalDateTime entryTime; // Date et heure d'entrée


    @Column
    private LocalDateTime exitTime; // Date et heure de sortie

       /*
        RELATION ENTRE LES TABLES
     */

    // TABLE VEHICULE
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle; // Association avec héhicule

    // TABLE UTILISATEURS
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Association avec l'utilisateur ayant effectué l'action


}
