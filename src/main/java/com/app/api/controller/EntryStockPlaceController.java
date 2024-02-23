package com.app.api.controller;

import com.app.api.model.EntryStockPlace;
import com.app.service.EntryStockPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry-stock-places")
public class EntryStockPlaceController {
    private final EntryStockPlaceService entryStockPlaceService;

    @Autowired
    public EntryStockPlaceController(EntryStockPlaceService entryStockPlaceService) {
        this.entryStockPlaceService = entryStockPlaceService;
    }

    @GetMapping("/get-entry-stock-places")
    public ResponseEntity<List<EntryStockPlace>> getEntryStockPlaces() {
        List<EntryStockPlace> entryStockPlaces = entryStockPlaceService.getEntryStockPlaces();
        if(entryStockPlaces != null) return ResponseEntity.ok(entryStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<EntryStockPlace> newEntryStockPlace(@RequestBody() EntryStockPlace entryStockPlace) {
        if(entryStockPlace == null)return ResponseEntity.badRequest().build();
        EntryStockPlace newEntryStockPlace = entryStockPlaceService.newEntryStockPlace(entryStockPlace);
        return ResponseEntity.ok(newEntryStockPlace);
    }

    @PostMapping("/load-entry-stock-places")
    public ResponseEntity<Void> loadEntryStockPlaces(@RequestBody() EntryStockPlace[] entryStockPlaces) {
        entryStockPlaceService.loadEntryStockPlaces(entryStockPlaces);
        return ResponseEntity.ok(null);
    }
}
