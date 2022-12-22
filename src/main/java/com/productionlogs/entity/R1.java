package com.productionlogs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "Field cant be null!")
    private LocalDateTime operationStart;
    @NotBlank(message = "Field cant be empty!")
    private String operation;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME , pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "Field cant be null!")
    private LocalDateTime operationFinish;
}
