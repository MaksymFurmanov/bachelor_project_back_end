package com.app.api.controller;

import com.app.api.model.ProductionProcess;
import com.app.service.ProductionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductionProcessController {
    private final ProductionProcessService productionProcessService;

    @Autowired
    public ProductionProcessController(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    @GetMapping("/production-processes/get-production-processes")
    public ResponseEntity<List<ProductionProcess>> getProductionProcesses() {
        List<ProductionProcess> productionProcesses = productionProcessService.getProductionProcesses();
        if(productionProcesses != null) return ResponseEntity.ok(productionProcesses);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/production-processes/load-production-processes")
    public ResponseEntity<Void> loadProductionProcesses(@RequestBody() ProductionProcess[] productionProcesses) {
        productionProcessService.loadProductionProcesses(productionProcesses);
        return ResponseEntity.ok(null);
    }
}
