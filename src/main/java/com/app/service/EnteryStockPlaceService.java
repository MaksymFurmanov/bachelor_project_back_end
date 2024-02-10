package com.app.service;

import com.app.api.model.EnteryStockPlace;
import com.app.repository.EnteryStockPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EnteryStockPlaceService {
    private final EnteryStockPlaceRepository enteryStockPlaceRepository;

    @Autowired
    public EnteryStockPlaceService(EnteryStockPlaceRepository enteryStockPlaceRepository) {
        this.enteryStockPlaceRepository = enteryStockPlaceRepository;
    }

    public List<EnteryStockPlace> getEnteryStockPlaces() {
        return enteryStockPlaceRepository.findAll();
    }

    public void loadEnteryStockPlaces(EnteryStockPlace[] enteryStockPlaces) {
        enteryStockPlaceRepository.saveAll(Arrays.asList(enteryStockPlaces));
    }
}
