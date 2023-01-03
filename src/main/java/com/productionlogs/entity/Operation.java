package com.productionlogs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime operationStart;
    private String operationDescription;
    private LocalDateTime operationFinish;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;
}
