package com.productionlogs.service;

import com.productionlogs.dto.OperationDto;
import com.productionlogs.entity.OperationStatus;
import com.productionlogs.exception.IDNotFoundException;
import com.productionlogs.repository.OperationRepository;
import com.productionlogs.service.mapper.JournalMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

//    public void save(R1 r1) {
//        r1.setOperationStatus(OperationStatus.UNVERIFIED);
//        operationRepository.save(r1);
//    }
//
//    public R1 map(OperationDto operationDto) {
//        return journalMapper.mapR1DtoToR1(operationDto);
//    }
//
//    @Transactional(readOnly = true)
//    public List<R1> findAll() {
//        return operationRepository.findAll();
//    }
//
//    public Page<R1> findAll(Pageable pageable) {
//        return operationRepository.findAll(pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public List<R1> findAllInDescendingOrder() {
//        return operationRepository.findAll()
//                .stream()
//                .sorted(Comparator.comparingLong(R1::getId).reversed())
//                .toList();
//    }
//
//    public R1 findById(long id) {
//        Optional<R1> byId = operationRepository.findById(id);
//        if (byId.isPresent()) {
//            return byId.get();
//        } else throw new IDNotFoundException();
//    }
//
//    public void changeOperationStatus(R1 r1) {
//        r1.setOperationStatus(OperationStatus.VERIFIED);
//    }
}
