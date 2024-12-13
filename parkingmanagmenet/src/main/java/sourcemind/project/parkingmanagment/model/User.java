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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // Nom de l'utilisateur

    @Column(nullable = false, unique = true)
    private String email; // Email

    @Column(nullable = false)
    private  String password; // Mot de passe

    @Column(nullable = false)
    private String role; // Rôle ADMIN, MANAGER, EMPLOYE

//    Association avec le journal d'activité
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ActivityLog>activityLogs;

}
