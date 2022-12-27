package com.productionlogs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "r1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime operationStart;
    private String operation;
    private LocalDateTime operationFinish;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;

    public R1(LocalDateTime operationStart, String operation, LocalDateTime operationFinish) {
        this.operationStart = operationStart;
        this.operation = operation;
        this.operationFinish = operationFinish;
    }
}
