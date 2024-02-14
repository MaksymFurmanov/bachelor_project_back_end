package com.app.service;

import com.app.api.model.OutputStockPlace;
import com.app.repository.OutputStockPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OutputStockPlaceService {
    private final OutputStockPlaceRepository outputStockPlaceRepository;

    @Autowired
    public OutputStockPlaceService(OutputStockPlaceRepository outputStockPlaceRepository) {
        this.outputStockPlaceRepository = outputStockPlaceRepository;
    }

    public List<OutputStockPlace> getOutputStockPlaces() {
        return outputStockPlaceRepository.findAll();
    }

    public void newOutputStockPlace (OutputStockPlace outputStockPlace) {
        outputStockPlaceRepository.save(outputStockPlace);
    }

    public void loadOutputStockPlaces(OutputStockPlace[] outputStockPlaces) {
        outputStockPlaceRepository.saveAll(Arrays.asList(outputStockPlaces));
    }
}
