package com.app.service;

import com.app.api.model.ProductionProcess;
import com.app.repository.ProductionProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductionProcessService {
    private final ProductionProcessRepository productionProcessRepository;

    @Autowired
    public ProductionProcessService(ProductionProcessRepository productionProcessRepository) {
        this.productionProcessRepository = productionProcessRepository;
    }

    public List<ProductionProcess> getProductionProcesses() {
        return productionProcessRepository.findAll();
    }

    public ProductionProcess newProductionProcess (ProductionProcess productionProcess) {
        ProductionProcess savedProductionProcess = productionProcessRepository.save(productionProcess);
        return productionProcessRepository
                .findById(savedProductionProcess.getProduction_process_id()).orElse(null);
    }

    public List<ProductionProcess> loadProductionProcesses(ProductionProcess[] productionProcesses) {
        return productionProcessRepository.saveAll(Arrays.asList(productionProcesses));
    }

    public void deleteProductionProcess(Long productionProcessId) {
        productionProcessRepository.deleteAllById(Collections.singleton(productionProcessId));
    }
}
