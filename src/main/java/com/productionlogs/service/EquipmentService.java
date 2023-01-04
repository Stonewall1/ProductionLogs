package com.productionlogs.service;

import com.productionlogs.dto.EquipmentDto;
import com.productionlogs.entity.Equipment;
import com.productionlogs.exception.IDNotFoundException;
import com.productionlogs.repository.EquipmentRepository;
import com.productionlogs.service.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    public Equipment mapToEquipment(EquipmentDto equipmentDto) {
        return equipmentMapper.mapEquipmentDtoToEquipment(equipmentDto);
    }

    @Transactional(readOnly = true)
    public List<Equipment> findAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment findByID(long id) {
        Optional<Equipment> byId = equipmentRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else throw new IDNotFoundException();
    }
}
