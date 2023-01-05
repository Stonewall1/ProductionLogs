package com.productionlogs.service;

import com.productionlogs.dto.OperationDto;
import com.productionlogs.entity.Equipment;
import com.productionlogs.entity.Operation;
import com.productionlogs.entity.OperationStatus;
import com.productionlogs.exception.IDNotFoundException;
import com.productionlogs.repository.OperationRepository;
import com.productionlogs.service.mapper.JournalMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JournalService {
    private final OperationRepository operationRepository;
    private final JournalMapper journalMapper;

    public JournalService(OperationRepository operationRepository, JournalMapper journalMapper) {
        this.operationRepository = operationRepository;
        this.journalMapper = journalMapper;
    }

    //  TODO adding user here

    public void save(Operation operation) {
        operation.setOperationStatus(OperationStatus.UNVERIFIED);
        operationRepository.save(operation);
    }

    public Operation mapToOperationAndBindEquipment(OperationDto operationDto, Equipment equipment) {
        Operation operation = journalMapper.mapOperationDtoToOperation(operationDto);
        operation.setEquipment(equipment);
        return operation;
    }

    public OperationDto presetOperationTime(OperationDto operationDto) {
        operationDto.setOperationStart(LocalDateTime.now());
        operationDto.setOperationFinish(LocalDateTime.now());
        return operationDto;
    }

    @Transactional(readOnly = true)
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Page<Operation> findAll(Pageable pageable) {
        return operationRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Operation> findAllInDescendingOrder() {
        return operationRepository.findAll()
                .stream()
                .sorted(Comparator.comparingLong(Operation::getId).reversed())
                .toList();
    }

    public Page<Operation> findAllOperationsByEquipmentID(Pageable pageable, long id) {
        return operationRepository.findOperationsByEquipmentId(pageable, id);
    }

    public Operation findById(long id) {
        Optional<Operation> byId = operationRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else throw new IDNotFoundException();
    }

    public void changeOperationStatus(Operation operation) {
        operation.setOperationStatus(OperationStatus.VERIFIED);
    }
}
