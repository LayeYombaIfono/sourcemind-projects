package projet.park.automobile.gestionparkautomobile.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TABLE_VEHICULE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle; // id de véhicule

    @Column(nullable = false, unique = true)
    private String licensePlate; // Plaque d'immatriculation

    @Column(nullable = false)
    private String ownerName; // Nom du propriétaire

    @Column
    private String model; // Modèle du véhicule

    @Column
    private  String color; // couleur du véhicule

    @Column(nullable = false)
    private  String fuelType; // Type de carburant: essence; diesel, électriaue, etc.

    /*
        RELATION ENTRE LE VEHICULE ET LA TABLE JOURNAL D'ACTIVITE
     */
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ActivityLog> activityLogs; //


}
