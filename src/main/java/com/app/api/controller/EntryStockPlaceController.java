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

    @GetMapping("")
    public ResponseEntity<List<EntryStockPlace>> getEntryStockPlaces() {
        List<EntryStockPlace> entryStockPlaces = entryStockPlaceService.getEntryStockPlaces();
        if(entryStockPlaces != null) return ResponseEntity.ok(entryStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/upload")
    public ResponseEntity<List<EntryStockPlace>>
    uploadEntryStockPlaces(@RequestBody() EntryStockPlace[] entryStockPlaces) {
        return ResponseEntity.ok(entryStockPlaceService.uploadEntryStockPlaces(entryStockPlaces));
    }
}
