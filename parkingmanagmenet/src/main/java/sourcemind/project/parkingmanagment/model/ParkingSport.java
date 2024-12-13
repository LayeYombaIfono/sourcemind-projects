package sourcemind.project.parkingmanagmenet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "place_parking")
public class ParkingSport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String spotNumber; // Numéro de la place

    @JoinColumn(nullable = false)
    private boolean isOccupied; // Statut de la place (occupée ou libre)

//    Rélation avec le véhicule si une place est occupé
    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;


}
