package com.jeongsu.moni.model;

import jakarta.persistence.*;

@Entity
public class TablespaceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TABLESPACENAME")
    private String tablespaceName;
    @Column(name = "USEDSPACE")
    private double usedSpace;
    @Column(name = "FREESPACE")
    private double freeSpace;

    // Getters and Setters
}