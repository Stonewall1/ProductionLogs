package com.productionlogs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne
    private Equipment equipment;
    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;
}
