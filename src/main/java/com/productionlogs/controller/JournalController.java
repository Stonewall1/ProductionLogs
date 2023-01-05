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

    @PostMapping("/{equipmentId}/{operationId}/{page}/updateStatus")
    public String updateStatus(@PathVariable("equipmentId") long equipmentId,
                               @PathVariable("operationId") long operationId,
                               @PathVariable("page") int currentPage) {
        Operation byId = journalService.findById(operationId);
        journalService.changeOperationStatus(byId);
        return "redirect:/equipment/equipmentPage/".concat(String.valueOf(equipmentId)).concat("?page=").concat(String.valueOf(currentPage));
    }
}
