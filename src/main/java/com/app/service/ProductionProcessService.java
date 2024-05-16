package com.app.service;

import com.app.api.model.Product;
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

    public List<ProductionProcess> uploadProductionProcesses(ProductionProcess[] productionProcesses) {
        Product product = productionProcesses.length > 0 ? productionProcesses[0].getProduct() : null;
        if (product != null) {
            List<ProductionProcess> existingProcesses = productionProcessRepository.findAllByProduct(product);
            productionProcessRepository.deleteAll(existingProcesses);
        }
        return productionProcessRepository.saveAll(Arrays.asList(productionProcesses));
    }

}
