package com.productionlogs.controller;

import com.productionlogs.entity.Operation;
import com.productionlogs.service.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journal")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/{EquipmentId}/{OperationId}/{page}/updateStatus")
    public String updateStatus(@PathVariable("EquipmentId") long equipmentId, @PathVariable("OperationId") long operationId, @PathVariable("page") int currentPage) {
        Operation byId = journalService.findById(operationId);
        journalService.changeOperationStatus(byId);
        return "redirect:/equipment/equipmentPage/" + equipmentId + "?page=" + currentPage;
    }
}
