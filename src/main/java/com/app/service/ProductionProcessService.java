package com.app.service;

import com.app.api.model.ProductionProcess;
import com.app.repository.ProductionProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void newProductionProcess (ProductionProcess productionProcess) {
        productionProcessRepository.save(productionProcess);
    }

    public void loadProductionProcesses(ProductionProcess[] productionProcesses) {
        productionProcessRepository.saveAll(Arrays.asList(productionProcesses));
    }
}
