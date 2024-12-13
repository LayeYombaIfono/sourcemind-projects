package sourcemind.project.parkingmanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "journal_activite")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    Association avec un vehicule
//    @OneToMany
//    @JoinColumn(name = "vehicle_id", nullable = false)
//    private Vehicle vehicle;

//    Association evec l'utilisateur ayant effectué l'action
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    //Date et l'heure d'entrée
    @Column(nullable = false)
    private LocalDateTime entryTime;

//    Date et heure de sortie
    @Column
    private LocalDateTime exitTime;



}
