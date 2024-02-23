package com.app.api.controller;

import com.app.api.model.ProductionProcess;
import com.app.service.ProductionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/production-processes")
public class ProductionProcessController {
    private final ProductionProcessService productionProcessService;

    @Autowired
    public ProductionProcessController(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    @GetMapping("/get-production-processes")
    public ResponseEntity<List<ProductionProcess>> getProductionProcesses() {
        List<ProductionProcess> productionProcesses = productionProcessService.getProductionProcesses();
        if(productionProcesses != null) return ResponseEntity.ok(productionProcesses);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<ProductionProcess> newProductionProcess(@RequestBody() ProductionProcess productionProcess) {
        if(productionProcess == null)return ResponseEntity.badRequest().build();
        ProductionProcess newProductionProcess = productionProcessService.newProductionProcess(productionProcess);
        return ResponseEntity.ok(newProductionProcess);
    }

    @PostMapping("/load-production-processes")
    public ResponseEntity<Void> loadProductionProcesses(@RequestBody() ProductionProcess[] productionProcesses) {
        System.out.println(Arrays.toString(productionProcesses));
        productionProcessService.loadProductionProcesses(productionProcesses);
        return ResponseEntity.ok(null);
    }
}
