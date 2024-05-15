package com.app.service;

import com.app.api.model.EntryStockPlace;
import com.app.repository.EntryStockPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntryStockPlaceService {
    private final EntryStockPlaceRepository entryStockPlaceRepository;

    @Autowired
    public EntryStockPlaceService(EntryStockPlaceRepository entryStockPlaceRepository) {
        this.entryStockPlaceRepository = entryStockPlaceRepository;
    }

    public List<EntryStockPlace> getEntryStockPlaces() {
        return entryStockPlaceRepository.findAll();
    }

    public List<EntryStockPlace> uploadEntryStockPlaces(EntryStockPlace[] entryStockPlaces) {
        return entryStockPlaceRepository.saveAll(Arrays.asList(entryStockPlaces));
    }
}
