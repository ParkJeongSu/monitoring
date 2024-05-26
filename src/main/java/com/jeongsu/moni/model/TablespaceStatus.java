package com.jeongsu.moni.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TablespaceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String tablespaceName;
    private double usedSpace;
    private double freeSpace;

    // Getters and Setters
}