package com.app.api.controller;

import com.app.api.model.ProductionProcess;
import com.app.service.ProductionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production-processes")
public class ProductionProcessController {
    private final ProductionProcessService productionProcessService;

    @Autowired
    public ProductionProcessController(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductionProcess>> getProductionProcesses() {
        List<ProductionProcess> productionProcesses = productionProcessService.getProductionProcesses();
        if (productionProcesses != null) return ResponseEntity.ok(productionProcesses);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/upload")
    public ResponseEntity<List<ProductionProcess>>
    uploadProductionProcesses(@RequestBody ProductionProcess[] productionProcesses) {
        return ResponseEntity.ok(productionProcessService.uploadProductionProcesses(productionProcesses));
    }
}
