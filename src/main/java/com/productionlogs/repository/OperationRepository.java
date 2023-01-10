package com.productionlogs.repository;

import com.productionlogs.entity.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    Page<Operation> findOperationsByEquipmentId(Pageable pageable, long id);
}
