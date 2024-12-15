package projet.park.automobile.gestionparkautomobile.model;

/*
    Classe des palces de park
 */

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TABLE_PLACE_PARKING")

   // CLASSE DE GESTION DES PLACES DU PARKING
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParkingSpot;

    @Column(nullable = false, unique = true)
    private String spotNumber; // Numéro de la place

    @Column(nullable = false)
    private boolean isOccupied; // Statut de la place (occupé ou libre)

    //Rélation avec unvéhicule si une place est occupée
    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "idVehicle")
    private Vehicle vehicle; //Véhicule garé sur cette place


}
