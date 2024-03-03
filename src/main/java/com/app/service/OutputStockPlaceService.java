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

    public OutputStockPlace newOutputStockPlace (OutputStockPlace outputStockPlace) {
        OutputStockPlace savedOutputStockPlace = outputStockPlaceRepository.save(outputStockPlace);
        return outputStockPlaceRepository
                .findById(savedOutputStockPlace.getOutput_stock_place_id()).orElse(null);
    }

    public List<OutputStockPlace> loadOutputStockPlaces(OutputStockPlace[] outputStockPlaces) {
        return outputStockPlaceRepository.saveAll(Arrays.asList(outputStockPlaces));
    }
}
