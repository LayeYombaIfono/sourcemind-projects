package com.example.parkingmanegement.parkingmanagement.entity;

import jakarta.persistence.*;

import java.util.Date;


/**
 * Représente un journal des activités dans le système.
 */
@Entity
@Table(name = "TABLE_JOURNAL_ACTIVITE")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date entryTime; // Date et heure d'entrée

    @Column
    private Date exitTime; // Date et heure de sortie (optionnel)



    //    CONSTRUCTEUR
    public ActivityLog() {
        super();
    }

    public ActivityLog(Date entryTime, Date exitTime) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }


//    GETTERS ET SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "id=" + id +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                '}';
    }
}
