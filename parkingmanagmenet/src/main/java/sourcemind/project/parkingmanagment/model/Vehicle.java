package sourcemind.project.parkingmanagmenet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vehicule")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licensePlate; // Plaque d'immaticulation

    @Column(nullable = false)
    private String ownerName; // Nom du propriétaire

    @Column
    private String model; // Model

    @Column
    private  String color; // Coleur

    @Column(nullable = false)
    private String fuelType; // Type de carburant: Essaence, Diesel, Electrique.

//    Association avec le journal d'activé
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ActivityLog>activityLogs;
}
